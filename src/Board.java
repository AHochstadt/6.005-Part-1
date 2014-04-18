import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.*;
import org.antlr.runtime.*;
import org.antlr.v4.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.runtime.CharStream;

import physics.Angle;
import physics.Circle;
import physics.Geometry;
import physics.Geometry.VectPair;
import physics.LineSegment;
import physics.Vect;

/**
* A class representing a users Pingball board
*
* Rep invariant: flippers, stationaryItems, and balls all must not be null
**/ 
public class Board {	
	public ArrayList<Ball> outgoingBalls = new ArrayList<Ball>(); 
	private ConcurrentHashMap<String, Gadget> triggerMap = new ConcurrentHashMap<String, Gadget>();
    private ArrayList<Stationary> nonMovingParts = null; //includes all gadgets and walls--basically anything that a ball can collide with except for other balls.
    private ArrayList<Flipper> flippers = null;
    public ArrayList<Ball> balls = null; //not final becuase balls can be added 
    private ArrayList<Wall> walls = null;
    private String leftWallName = ""; //either states the name of the board the wall is connected to or the empty string if it is a solid wall
    private String rightWallName = ""; //either states the name of the board the wall is connected to or the empty string if it is a solid wall
    private String upWallName = ""; //either states the name of the board the wall is connected to or the empty string if it is a solid wall
    private String downWallName = ""; //either states the name of the board the wall is connected to or the empty string if it is a solid wall
    private boolean leftWallSolid = true;
    private boolean upWallSolid = true;
    private boolean downWallSolid = true;
    private boolean rightWallSolid = true;
    private String boardName = "";
	private double gravity = 25.0; //default value
	private double friction1 = .025; //default value
	private double friction2 = .025; //default value
	private Wall leftWall;
	private Wall upWall;
	private Wall rightWall;
	private Wall downWall;
	
    
    /**
     * @author ahochstadt
     * creates a new instance of board from the input file
     * @param filePath the address of the Pingball Board File specifying the board
     * @throws IOException 
     */
	public Board(String filePath) throws IOException {
	    try {
	        ANTLRInputStream stream = new ANTLRInputStream(new FileReader(filePath));
	        BoardMakerLexer lexer = new BoardMakerLexer((org.antlr.v4.runtime.CharStream) stream);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        BoardMakerParser parser = new BoardMakerParser((org.antlr.v4.runtime.TokenStream) tokens);
	        ParseTree tree = parser.file();
	        //((RuleContext)tree).inspect(parser);

	        ParseTreeWalker walker = new ParseTreeWalker(); 
	        MakerListener listener = new MakerListener(); 
	        walker.walk(listener, tree);



	        this.walls = new ArrayList<Wall>();
	        this.nonMovingParts = listener.getStationary();
	        this.flippers = listener.getFlippers();
	        this.balls = listener.getBalls();
	       

	        int badNumber = -9999;
	        if (listener.getGravity() != badNumber){
	            this.gravity = (double) listener.getGravity();
	        }
	        if (listener.getFriction1() != badNumber){
	            this.friction1 = (double) listener.getFriction1();
	        }

	        if (listener.getFriction2() != badNumber){
	            this.friction2 = (double) listener.getFriction2();
	        }

	        this.boardName = listener.getBoardName();
	        this.triggerMap = listener.getTriggerMap(); //puts all of the mappings into a ConcurrentHashMap this.triggerMap
	        
	        for (Gadget g: listener.getPartsList()) {
	            g.setParentBoard(this);
	        }

	     }

	catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	leftWall = new Wall(this, "left"); //adds walls to board, solid by default
	upWall = new Wall(this, "up");
	rightWall = new Wall(this, "right");
	downWall = new Wall(this, "down");

	this.walls.clear(); 
	this.walls.add(upWall); this.walls.add(leftWall); this.walls.add(downWall); this.walls.add(rightWall); //populates this.walls

}

    /**
     * @author ahochstadt
     * @param timestep timestep in seconds
     * @return String representing the boards current state: will use the following procedure:
     * find first collision
     * set all ball positions to right before the collision(s)
     * execute collision(s)
     * repeat until the timestep is over
     */
    public String update(double timestep) {
    	double timeElapsed = 0.0;
    	double timeLeft = timestep;
    	
    	for (Ball b: balls) { //set all balls to their new velocities so we can begin updating
    	    if (!b.inAbsorberQueue) {
    		double proposedXVel = b.getVelocity().x()*(1-this.friction1*timestep - this.friction2*b.getVelocity().x()*timestep); //from approximation formula given in assignment
    		double proposedYVel = b.getVelocity().y()*(1-this.friction1*timestep - this.friction2*b.getVelocity().y()*timestep); //from approximation formula given in assignment
    		proposedYVel += this.gravity*timestep; //approximate new y velocity due to gravity. += because +y is defined as down
    		Vect proposedVel = new Vect(proposedXVel, proposedYVel);
    		b.setVelocity(proposedVel);
    	    }
    	}
    	
    	while (timeElapsed < timestep){
	    	double timeUntilFirstCollision = getTimeUntilFirstCollision(timestep);
	    	if (timeUntilFirstCollision<=timeLeft){
	    		updateWithCollision(timeUntilFirstCollision);
	    		timeLeft -= timeUntilFirstCollision;
	    		timeElapsed += timeUntilFirstCollision;
	    	} else { //there are no more collisions in this timestep
	    		updateWithoutCollision(timeLeft);
	    		timeLeft = 0.0;
	    		timeElapsed = timestep;
	    	}
	    	
    	}
    	
    	return getBoardRep();
    }
    
    /**
     * A helper method to update(timestep) that updates the balls without any collisions
     * @param timeLeft the timestep to execute
     */
    private void updateWithoutCollision(double timeLeft) {
		for (Ball b: balls){
			b.setBallVector(new Vect(b.getBallVector().x()+timeLeft*b.getVelocity().x(), b.getBallVector().y()+timeLeft*b.getVelocity().y())); //travels to the space with no collisions
		}
		for (Flipper f: this.flippers){
			f.moveFlipper(timeLeft);
		}
		
	}
	/**
     * @author ahochstadt
     * A helper method to update. Called when there's a collision within update's timestep. Advances all balls to the moment right before the collision and changes 
     * the colliding ball's (or balls') velocity (or velocities) appropriately.
     * @param timeUntilFirstCollision the time until the collision occurs
     */
    private void updateWithCollision(double timeUntilFirstCollision) {
    	ArrayList<Boolean> collidedArray = new ArrayList<Boolean>(); //an array that tells us whether a ball has already collided with another ball. Used in the loops below
    	for (int i=0; i<balls.size(); i++) { //initialize collidedArray as all false booleans
    		collidedArray.add(false);
    	}
    	for (int i=0; i<balls.size(); i++) {
    		Ball ball1 = balls.get(i);
            for (int j=0; j<balls.size(); j++) {
            	Ball ball2 = balls.get(j);
            	if (i!=j && !collidedArray.get(i) && !collidedArray.get(j)){ //makes sure we have different balls and we haven't yet collided them before
	                double timeUntilCollision = Geometry.timeUntilBallBallCollision(ball1.getPhysicsPackageCircle(), ball1.getPhysicsPackageVelocity(), ball2.getPhysicsPackageCircle(), ball2.getPhysicsPackageVelocity());
	                if (timeUntilCollision<=timeUntilFirstCollision){ //we have a new collision
	        			VectPair newVels = Geometry.reflectBalls(ball1.getPhysicsPackageBallVector(), 1.0, ball1.getPhysicsPackageVelocity(), ball2.getPhysicsPackageBallVector(), 1.0, ball2.getPhysicsPackageVelocity());
	        			ball1.setVelocity(newVels.v1);
	        			ball2.setVelocity(newVels.v2);
	        			collidedArray.set(i, true);
	        			collidedArray.set(j, true);
	        		}
            	}
            }
        }
    	for (int i=0; i<balls.size(); i++) {
    		Ball b = balls.get(i);
    		if (!b.inAbsorberQueue) {
    		boolean collidedAlready = collidedArray.get(i);
    		
    		for (Stationary s: nonMovingParts) { //iterate through stationary gadgets
                for (Object objectHit: s.getPhysicsObjects()){
                	if (objectHit instanceof Circle){ 
                		Circle circleHit = (Circle) objectHit;
                		double timeUntilCollision = Geometry.timeUntilCircleCollision(circleHit, b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
                		if(collidedAlready){
                			if (timeUntilCollision==0.0){//this is a collision

                				s.getEffect(b, circleHit);
                                s.trigger();
                			}
                		} else { //this ball has not yet collided
                			if (timeUntilCollision<=timeUntilFirstCollision){//this is a collision
                				b.setBallVector(new Vect(b.getBallVector().x()+timeUntilCollision*b.getVelocity().x(), b.getBallVector().y()+timeUntilCollision*b.getVelocity().y())); //travels to the space where the ball will collide
                				s.getEffect(b, circleHit);
                                s.trigger();
                				collidedAlready = true;
                    		}
                		}
                		
                	} else if (objectHit instanceof LineSegment){ //if it's not a Circle, it should hypothetically be a LineSegment
            			LineSegment lineSegmentHit = (LineSegment) objectHit;
                		double timeUntilCollision = Geometry.timeUntilWallCollision(lineSegmentHit, b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
                		if(collidedAlready){
                			if (timeUntilCollision==0.0){//this is a collision

                				s.getEffect(b, lineSegmentHit);
                                s.trigger();
                			}
                		} else { //this ball has not yet collided
                			if (timeUntilCollision<=timeUntilFirstCollision){//this is a collision
                				b.setBallVector(new Vect(b.getBallVector().x()+timeUntilCollision*b.getVelocity().x(), b.getBallVector().y()+timeUntilCollision*b.getVelocity().y())); //travels to the space where the ball will collide
                				s.getEffect(b, lineSegmentHit);
                                s.trigger();
                				collidedAlready = true;
                    		}
                		}
                	}
                }
            }
            for (Stationary s: walls) { //iterate through walls
            	for (Object objectHit: s.getPhysicsObjects()){
                	if (objectHit instanceof Circle){ 
                		Circle circleHit = (Circle) objectHit;
                		double timeUntilCollision = Geometry.timeUntilCircleCollision(circleHit, b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
                		if(collidedAlready){
                			if (timeUntilCollision==0.0){//this is a collision
                				s.getEffect(b, circleHit);
                			}
                		} else { //this ball has not yet collided
                			if (timeUntilCollision<=timeUntilFirstCollision){//this is a collision
                				b.setBallVector(new Vect(b.getBallVector().x()+timeUntilCollision*b.getVelocity().x(), b.getBallVector().y()+timeUntilCollision*b.getVelocity().y())); //travels to the space where the ball will collide
                				s.getEffect(b, circleHit);
                				collidedAlready = true;
                    		}
                		}
                		
                	} else if (objectHit instanceof LineSegment){ //if it's not a Circle, it should hypothetically be a LineSegment
            			LineSegment lineSegmentHit = (LineSegment) objectHit;
                		double timeUntilCollision = Geometry.timeUntilWallCollision(lineSegmentHit, b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
                		if(collidedAlready){
                			if (timeUntilCollision==0.0){//this is a collision
                				s.getEffect(b, lineSegmentHit);
                			}
                		} else { //this ball has not yet collided
                			if (timeUntilCollision<=timeUntilFirstCollision){//this is a collision
                				b.setBallVector(new Vect(b.getBallVector().x()+timeUntilCollision*b.getVelocity().x(), b.getBallVector().y()+timeUntilCollision*b.getVelocity().y())); //travels to the space where the ball will collide
                				s.getEffect(b, lineSegmentHit);
                				collidedAlready = true;
                    		}
                		}
                	}
                }
            }
            
            for (Flipper f: flippers) { //iterate through flippers
            	if (!(f.isFlipping() || f.isFlippingBack())){//the flipper is stationary. Let's take care of this case first
	            	for (Object objectHit: f.getPhysicsObjects()){
	                	if (objectHit instanceof Circle){ 
	                		Circle circleHit = (Circle) objectHit;
	                		double timeUntilCollision = Geometry.timeUntilCircleCollision(circleHit, b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
	                		if(collidedAlready){
	                			if (timeUntilCollision==0.0){//this is a collision
	                				f.getEffect(b, circleHit);
	                			}
	                		} else { //this ball has not yet collided
	                			if (timeUntilCollision<=timeUntilFirstCollision){//this is a collision
	                				b.setBallVector(new Vect(b.getBallVector().x()+timeUntilCollision*b.getVelocity().x(), b.getBallVector().y()+timeUntilCollision*b.getVelocity().y())); //travels to the space where the ball will collide
	                				f.getEffect(b, circleHit);
	                				collidedAlready = true;
	                    		}
	                		}
	                		
	                	} else if (objectHit instanceof LineSegment){ //if it's not a Circle, it should hypothetically be a LineSegment
	            			LineSegment lineSegmentHit = (LineSegment) objectHit;
	                		double timeUntilCollision = Geometry.timeUntilWallCollision(lineSegmentHit, b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
	                		if(collidedAlready){
	                			if (timeUntilCollision==0.0){//this is a collision
	                				f.getEffect(b, lineSegmentHit);
	                			}
	                		} else { //this ball has not yet collided
	                			if (timeUntilCollision<=timeUntilFirstCollision){//this is a collision
	                				b.setBallVector(new Vect(b.getBallVector().x()+timeUntilCollision*b.getVelocity().x(), b.getBallVector().y()+timeUntilCollision*b.getVelocity().y())); //travels to the space where the ball will collide
	                				f.getEffect(b, lineSegmentHit);
	                				collidedAlready = true;
	                    		}
	                		}
	                	}
	                }
	            } else { //the flippers are moving
	            	for (Object objectHit: f.getPhysicsObjects()){
	            		if (objectHit instanceof Circle){ 
	                		Circle circleHit = (Circle) objectHit;
	                		/////////////////
	            			double timeUntilCollision = timeUntilFirstCollision +1; //initialize timeUntilCollision
	                		Circle proposedEndpt = f.getEndpt(); //meaningless initialization inside the flipper's bounding box.
	                		if (circleHit.equals(f.getPivot())){
	                			timeUntilCollision = Geometry.timeUntilBallBallCollision(f.getPivot(), new Vect(0.0,0.0), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
	                		} else { //the circle is an endpoint of the flipper
		            			if (f instanceof LeftFlipper){
		                			if (f.isFlipping()){ //flipper is in process of flipping (moving with a +theta angular velocity for left flipper)
		                				timeUntilCollision = Geometry.timeUntilRotatingCircleCollision(circleHit, f.getPivot().getCenter(), f.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
		                				proposedEndpt = Geometry.rotateAround(circleHit, f.getPivot().getCenter(), new Angle(f.getAngularVelocity()*timeUntilCollision));
		                			} else if (f.isFlippingBack()){ //flipper is in process of flippingBack (moving with a -theta angular velocity for left flipper)
		                				timeUntilCollision = Geometry.timeUntilRotatingCircleCollision(circleHit, f.getPivot().getCenter(), (-1)*f.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
		                				proposedEndpt = Geometry.rotateAround(circleHit, f.getPivot().getCenter(), new Angle((-1)*f.getAngularVelocity()*timeUntilCollision));
		                			}
		            			} else if (f instanceof RightFlipper) {
		            				if (f.isFlipping()){ //flipper is in process of flipping (moving with a -theta angular velocity for right flipper)
		            					timeUntilCollision = Geometry.timeUntilRotatingCircleCollision(circleHit, f.getPivot().getCenter(), (-1)*f.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
		                				proposedEndpt = Geometry.rotateAround(circleHit, f.getPivot().getCenter(), new Angle((-1)*f.getAngularVelocity()*timeUntilCollision));
		                			} else if (f.isFlippingBack()){ //flipper is in process of flippingBack (moving with a +theta angular velocity for right flipper)
		                				timeUntilCollision = Geometry.timeUntilRotatingCircleCollision(circleHit, f.getPivot().getCenter(), f.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
		                				proposedEndpt = Geometry.rotateAround(circleHit, f.getPivot().getCenter(), new Angle(f.getAngularVelocity()*timeUntilCollision));
		                			}
		            			}
		            			if (timeUntilCollision<=timeUntilFirstCollision){
		            				if (f.inBoundingBox(proposedEndpt)){ //makes sure that we aren't extending past the boundingBox when we collide with the ball. This check may not work if timeStep*f.getAngularVelocity >= 270, but that would have to mean a high angular velocity and a long timeStep (5 times longer than our current timestep of .05 at our angular velocity of 1080 L/sec) 
		            					b.setBallVector(new Vect(b.getBallVector().x()+timeUntilCollision*b.getVelocity().x(), b.getBallVector().y()+timeUntilCollision*b.getVelocity().y())); //travels to the space where the ball will collide
		                				//f.trigger();
		                				f.getEffect(b, circleHit);
		                				collidedAlready = true;
		            				}
		                   		}
	                		}
	                				
	            		} else if (objectHit instanceof LineSegment){
	            			LineSegment lineSegmentHit = (LineSegment) objectHit;
	            			double timeUntilCollision = timeUntilFirstCollision +1; //initialize timeUntilCollision
	            			Circle proposedEndpt = f.getEndpt(); //meaningless initialization inside the flipper's bounding box.
	            			if (f instanceof LeftFlipper){
	                			if (f.isFlipping()){ //flipper is in process of flipping (moving with a +theta angular velocity for left flipper)
	                				timeUntilCollision = Geometry.timeUntilRotatingWallCollision(lineSegmentHit, f.getPivot().getCenter(), f.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
	                				proposedEndpt = Geometry.rotateAround(f.getEndpt(), f.getPivot().getCenter(), new Angle(f.getAngularVelocity()*timeUntilCollision));
	                			} else if (f.isFlippingBack()){ //flipper is in process of flippingBack (moving with a -theta angular velocity for left flipper)
	                				timeUntilCollision = Geometry.timeUntilRotatingWallCollision(lineSegmentHit, f.getPivot().getCenter(), (-1)*f.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
	                				proposedEndpt = Geometry.rotateAround(f.getEndpt(), f.getPivot().getCenter(), new Angle((-1)*f.getAngularVelocity()*timeUntilCollision));
	                			}
	            			} else if (f instanceof RightFlipper) {
	            				if (f.isFlipping()){ //flipper is in process of flipping (moving with a -theta angular velocity for right flipper)
	                				timeUntilCollision = Geometry.timeUntilRotatingWallCollision(lineSegmentHit, f.getPivot().getCenter(), (-1)*f.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
	                				proposedEndpt = Geometry.rotateAround(f.getEndpt(), f.getPivot().getCenter(), new Angle((-1)*f.getAngularVelocity()*timeUntilCollision));
	                			} else if (f.isFlippingBack()){ //flipper is in process of flippingBack (moving with a +theta angular velocity for right flipper)
	                				timeUntilCollision = Geometry.timeUntilRotatingWallCollision(lineSegmentHit, f.getPivot().getCenter(), f.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
	                				proposedEndpt = Geometry.rotateAround(f.getEndpt(), f.getPivot().getCenter(), new Angle(f.getAngularVelocity()*timeUntilCollision));
	                			}
	            			}
	            			if (timeUntilCollision<=timeUntilFirstCollision){
	            				if (f.inBoundingBox(proposedEndpt)){ //makes sure that we aren't extending past the boundingBox when we collide with the ball. This check may not work if timeStep*f.getAngularVelocity >= 270, but that would have to mean a high angular velocity and a long timeStep (5 times longer than our current timestep of .05 at our angular velocity of 1080 L/sec) 
	            					b.setBallVector(new Vect(b.getBallVector().x()+timeUntilCollision*b.getVelocity().x(), b.getBallVector().y()+timeUntilCollision*b.getVelocity().y())); //travels to the space where the ball will collide
	                				//f.trigger();
	                				f.getEffect(b, lineSegmentHit);
	                				collidedAlready = true;
	            				}
	                   		}
	            		}
	            	}
	            }
            	f.moveFlipper(timeUntilFirstCollision);
	        }
            if (!collidedAlready){
				b.setBallVector(new Vect(b.getBallVector().x()+timeUntilFirstCollision*b.getVelocity().x(), b.getBallVector().y()+timeUntilFirstCollision*b.getVelocity().y())); //travels to the space with no collisions
            }
        }
    	}
	}
	/**
     * @author ahochstadt
     * @param timestep timestep in update(timestep). Used only to initialize return value at a value higher than timestep.
     * @return the time at which the collision occurs or timestep+1 if it's > timestep+1;
     */
    private double getTimeUntilFirstCollision(double timestep) {
    	double timeUntilFirstCollision = timestep + 1.0;
    	for (Ball b: balls) {
    	    if (!b.inAbsorberQueue) {
            for (Stationary s: nonMovingParts) { //iterate through stationary gadgets
                for (Object objectHit: s.getPhysicsObjects()){
                	if (objectHit instanceof LineSegment){
            			LineSegment lineSegmentHit = (LineSegment) objectHit;
                		double timeUntilCollision = Geometry.timeUntilWallCollision(lineSegmentHit, b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
                		if (lineSegmentHit.p1().x() == 0.0 && lineSegmentHit.p1().y() == 2.0 && lineSegmentHit.p2().x() == 1.0 && lineSegmentHit.p2().y() == 2.0){ //this is the first wall of the square bumper
                			System.out.println(timeUntilCollision);
                			System.out.println(b.getBallVector());
                		}
                		if (timeUntilCollision<timeUntilFirstCollision){
                			timeUntilFirstCollision = timeUntilCollision;
                		}
                	} else if (objectHit instanceof Circle){ //if it's not a LineSegment, it should hypothetically be a circle
                		Circle circleHit = (Circle) objectHit;
                		double timeUntilCollision = Geometry.timeUntilCircleCollision(circleHit, b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
                		if (timeUntilCollision<timeUntilFirstCollision){
                			timeUntilFirstCollision = timeUntilCollision;
                		}
                	}
                }
            }
            for (Stationary s: walls) { //iterate through walls
                for (Object objectHit: s.getPhysicsObjects()){
                	if (objectHit instanceof LineSegment){
            			LineSegment lineSegmentHit = (LineSegment) objectHit;
                		double timeUntilCollision = Geometry.timeUntilWallCollision(lineSegmentHit, b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
                		if (timeUntilCollision<timeUntilFirstCollision){
                			timeUntilFirstCollision = timeUntilCollision;
                		}
                	} else if (objectHit instanceof Circle){ //if it's not a LineSegment, it should hypothetically be a circle
                		Circle circleHit = (Circle) objectHit;
                		double timeUntilCollision = Geometry.timeUntilCircleCollision(circleHit, b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
                		if (timeUntilCollision<timeUntilFirstCollision){
                			timeUntilFirstCollision = timeUntilCollision;
                		}
                	}
                }
            }
            for (Flipper f: flippers) { //iterate through flippers
                for (Object objectHit: f.getPhysicsObjects()){
                	if (objectHit instanceof LineSegment){
            			LineSegment lineSegmentHit = (LineSegment) objectHit;
            			double timeUntilCollision = timeUntilFirstCollision +1; //initialize timeUntilCollision
            			Circle proposedEndpt = f.getEndpt(); //meaningless initialization inside the flipper's bounding box.
            			if (f instanceof LeftFlipper){
                			if (f.isFlipping()){ //flipper is in process of flipping (moving with a +theta angular velocity for left flipper)
                				timeUntilCollision = Geometry.timeUntilRotatingWallCollision(lineSegmentHit, f.getPivot().getCenter(), f.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
                				proposedEndpt = Geometry.rotateAround(f.getEndpt(), f.getPivot().getCenter(), new Angle(f.getAngularVelocity()*timeUntilCollision));
                			} else if (f.isFlippingBack()){ //flipper is in process of flippingBack (moving with a -theta angular velocity for left flipper)
                				timeUntilCollision = Geometry.timeUntilRotatingWallCollision(lineSegmentHit, f.getPivot().getCenter(), (-1)*f.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
                				proposedEndpt = Geometry.rotateAround(f.getEndpt(), f.getPivot().getCenter(), new Angle((-1)*f.getAngularVelocity()*timeUntilCollision));
                			} else { //flipper is not moving
                				timeUntilCollision = Geometry.timeUntilWallCollision(lineSegmentHit, b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
                			}
            			} else if (f instanceof RightFlipper) {
            				if (f.isFlipping()){ //flipper is in process of flipping (moving with a -theta angular velocity for right flipper)
                				timeUntilCollision = Geometry.timeUntilRotatingWallCollision(lineSegmentHit, f.getPivot().getCenter(), (-1)*f.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
                				proposedEndpt = Geometry.rotateAround(f.getEndpt(), f.getPivot().getCenter(), new Angle((-1)*f.getAngularVelocity()*timeUntilCollision));
                			} else if (f.isFlippingBack()){ //flipper is in process of flippingBack (moving with a +theta angular velocity for right flipper)
                				timeUntilCollision = Geometry.timeUntilRotatingWallCollision(lineSegmentHit, f.getPivot().getCenter(), f.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
                				proposedEndpt = Geometry.rotateAround(f.getEndpt(), f.getPivot().getCenter(), new Angle(f.getAngularVelocity()*timeUntilCollision));
                			} else { //flipper is not moving
                				timeUntilCollision = Geometry.timeUntilWallCollision(lineSegmentHit, b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
                			}
            			}
            			if (timeUntilCollision<timeUntilFirstCollision){
            				if (f.inBoundingBox(proposedEndpt)){ //makes sure that we aren't extending past the boundingBox when we collide with the ball. This check may not work if timeStep*f.getAngularVelocity >= 270, but that would have to mean a high angular velocity and a long timeStep (5 times longer than our current timestep of .05 at our angular velocity of 1080 L/sec) 
                    			timeUntilFirstCollision = timeUntilCollision;
            				}
                   		}
            			
                	} else if (objectHit instanceof Circle){ //if it's not a LineSegment, it should hypothetically be a circle
                		Circle circleHit = (Circle) objectHit;
                		double timeUntilCollision = timeUntilFirstCollision +1; //initialize timeUntilCollision
                		Circle proposedEndpt = f.getEndpt(); //meaningless initialization inside the flipper's bounding box.
                		if (circleHit.equals(f.getPivot())){
                			timeUntilCollision = Geometry.timeUntilBallBallCollision(f.getPivot(), new Vect(0.0,0.0), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
                		} else { //the circle is an endpoint of the flipper
	            			if (f instanceof LeftFlipper){
	                			if (f.isFlipping()){ //flipper is in process of flipping (moving with a +theta angular velocity for left flipper)
	                				timeUntilCollision = Geometry.timeUntilRotatingCircleCollision(circleHit, f.getPivot().getCenter(), f.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
	                				proposedEndpt = Geometry.rotateAround(circleHit, f.getPivot().getCenter(), new Angle(f.getAngularVelocity()*timeUntilCollision));
	                			} else if (f.isFlippingBack()){ //flipper is in process of flippingBack (moving with a -theta angular velocity for left flipper)
	                				timeUntilCollision = Geometry.timeUntilRotatingCircleCollision(circleHit, f.getPivot().getCenter(), (-1)*f.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
	                				proposedEndpt = Geometry.rotateAround(circleHit, f.getPivot().getCenter(), new Angle((-1)*f.getAngularVelocity()*timeUntilCollision));
	                			} else { //flipper is not moving
	                				timeUntilCollision = Geometry.timeUntilCircleCollision(circleHit, b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
	                			}
	            			} else if (f instanceof RightFlipper) {
	            				if (f.isFlipping()){ //flipper is in process of flipping (moving with a -theta angular velocity for right flipper)
	            					timeUntilCollision = Geometry.timeUntilRotatingCircleCollision(circleHit, f.getPivot().getCenter(), (-1)*f.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
	                				proposedEndpt = Geometry.rotateAround(circleHit, f.getPivot().getCenter(), new Angle((-1)*f.getAngularVelocity()*timeUntilCollision));
	                			} else if (f.isFlippingBack()){ //flipper is in process of flippingBack (moving with a +theta angular velocity for right flipper)
	                				timeUntilCollision = Geometry.timeUntilRotatingCircleCollision(circleHit, f.getPivot().getCenter(), f.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
	                				proposedEndpt = Geometry.rotateAround(circleHit, f.getPivot().getCenter(), new Angle(f.getAngularVelocity()*timeUntilCollision));
	                			} else { //flipper is not moving
	                				timeUntilCollision = Geometry.timeUntilCircleCollision(circleHit, b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity());
	                			}
	            			}
	            			if (timeUntilCollision<timeUntilFirstCollision){
	            				if (f.inBoundingBox(proposedEndpt)){ //makes sure that we aren't extending past the boundingBox when we collide with the ball. This check may not work if timeStep*f.getAngularVelocity >= 270, but that would have to mean a high angular velocity and a long timeStep (5 times longer than our current timestep of .05 at our angular velocity of 1080 L/sec) 
	                    			timeUntilFirstCollision = timeUntilCollision;
	            				}
	                   		}
                		}
                	}
                }
            }
    	    }
        }
        for (Ball ball1: balls) {
            for (Ball ball2: balls) {
            	if (!ball1.equals(ball2)){ //make sure that the balls are different balls
	                double timeUntilCollision = Geometry.timeUntilBallBallCollision(ball1.getPhysicsPackageCircle(), ball1.getPhysicsPackageVelocity(), ball2.getPhysicsPackageCircle(), ball2.getPhysicsPackageVelocity());
	                if (timeUntilCollision<timeUntilFirstCollision){
	        			timeUntilFirstCollision = timeUntilCollision;
	        		}
            	}
            }
        }
		return timeUntilFirstCollision;
	}
	/**
     * adds new ball to the board 
     * @param b
     */
    public void addBall(Ball b) {
        balls.add(b);
    }
    
    /**
     * removes ball from this board
     * sends ball in a message to the server along with, the name of the board that the ball has come from 
     * @param b
     */
    public String removeBall(Ball b) {
        balls.remove(b);
        //returns a String board message including information about the ball and the board that it came from  
        return "";
    }
    
    
    /**
     * 
     * @return String representation of the board's current state
     */
    public String getBoardRep() {
        String tWall = "";
        String bWall = "";
        String rWall = "";
        String lWall = "";
        Character[][] boardArray = new Character[20][20];
        if (upWall.getName() != null) {
            tWall = upWall.getName(); 
        }

        if (downWall.getName() != null) {
            bWall = downWall.getName();
        }

        if (leftWall.getName() != null) {
            lWall = leftWall.getName();
        }

        if (rightWall.getName() != null) {
            rWall = rightWall.getName();
        }

        for (int p = 0; p < 20; p++) {
            for (int q = 0; q < 20; q++) {
                boardArray[p][q] = ' ';
            }
        }
        
        for (Stationary g: this.nonMovingParts) {
            if (g instanceof Absorber) {
                int x = (int) ((Absorber) g).getX(); //upper left
                int y = (int) ((Absorber) g).getY(); //upper left 
                int height = (int) ((Absorber) g).getHeight(); 
                int width = (int) ((Absorber) g).getWidth(); 
                for (int k = 0; k < width; k++) {
                    for (int j = 0; j < height; j++) {
                        int xValue = x+k;
                        int yValue = y+j;
                        boardArray[xValue][yValue] = '=';
                    }
                }
            }
            
            else {
                if (g instanceof SquareBumper) {
                    int x = (int)((SquareBumper) g).getX();
                    int y = (int)((SquareBumper) g).getY();
                    boardArray[x][y] = '#';  
                }

                if (g instanceof CircularBumper) {
                    int x = (int)((CircularBumper) g).getX();
                    int y = (int)((CircularBumper) g).getY();
                    boardArray[x][y] = 'O';
                }

                if (g instanceof TriangularBumper) {
                    int x = (int)((TriangularBumper) g).getX();
                    int y = (int)((TriangularBumper) g).getY();
                    boardArray[x][y] = '\\'; 
                }
            }

            for (Flipper f: flippers) {
                int fixedX = (int) ((Flipper) f).getFixedX();
                int fixedY = (int) ((Flipper) f).getFixedY();
                

                if (f instanceof LeftFlipper) {
                    int orientation = (int) ((LeftFlipper) f).getOrientation();
                    boolean flipped = ((LeftFlipper) f).isFlipped();

                    if (orientation == 0) {
                        if (flipped) {
                            boardArray[fixedX][fixedY] = '-';
                            boardArray[fixedX+1][fixedY] = '-';
                        }

                        else {
                            boardArray[fixedX][fixedY] = '|';
                            boardArray[fixedX][fixedY+1] = '|';

                        }
                    }

                    else if (orientation == 90) {
                        if (flipped) {
                            boardArray[fixedX-1][fixedY] = '|';
                            boardArray[fixedX-1][fixedY+1] = '|';
                        }

                        else {
                            boardArray[fixedX-1][fixedY] = '-';
                            boardArray[fixedX-1][fixedY] = '-';
                        }

                    }

                    else if (orientation == 180) {
                        if (flipped) {
                            boardArray[fixedX-1][fixedY-1] = '-';
                            boardArray[fixedX-2][fixedY-1] = '-';
                        }

                        else {
                            boardArray[fixedX-1][fixedY-1] = '|';
                            boardArray[fixedX-1][fixedY-2] = '|';

                        }

                    }

                    else {
                        if (flipped) {
                            boardArray[fixedX][fixedY-1] = '|';
                            boardArray[fixedX][fixedY-2] = '|';
                        }

                        else {
                            boardArray[fixedX][fixedY-1] = '-';
                            boardArray[fixedX+1][fixedY-1] = '-';
                        }

                    }

                }

                else {
                    int orientation = (int) ((RightFlipper) f).getOrientation();
                    boolean flipped = ((RightFlipper) f).isFlipped();

                    if (orientation == 0) {
                        if (flipped) {
                            boardArray[fixedX-1][fixedY] = '-';
                            boardArray[fixedX-1][fixedY] = '-';
                        }

                        else {
                            boardArray[fixedX-1][fixedY] = '|';
                            boardArray[fixedX-1][fixedY+1] = '|';

                        }
                    }

                    else if (orientation == 90) {
                        if (flipped) {
                            boardArray[fixedX-1][fixedY-1] = '|';
                            boardArray[fixedX-1][fixedY-2] = '|';
                        }

                        else {
                            boardArray[fixedX-1][fixedY-1] = '-';
                            boardArray[fixedX-2][fixedY-1] = '-';
                        }

                    }

                    else if (orientation == 180) {
                        if (flipped) {
                            boardArray[fixedX][fixedY-1] = '|';
                            boardArray[fixedX][fixedY-2] = '|';
                        }

                        else {
                            boardArray[fixedX][fixedY-1] = '-';
                            boardArray[fixedX+1][fixedY-1] = '-';
                        }

                    }

                    else {
                        if (flipped) {
                            boardArray[fixedX][fixedY] = '-';
                            boardArray[fixedX+1][fixedY] = '-';
                        }

                        else {
                            boardArray[fixedX][fixedY] = '|';
                            boardArray[fixedX][fixedY+1] = '|';
                        }

                    }

                }
            }
        }
        for (Ball b: balls) {
            int x = (int) b.getBallVector().x();
            int y = (int) b.getBallVector().y();
            boardArray[x][y] = '*';
        }
        
        String boardRep = ""; 
        for (int w = 0; w < 22; w++) {
            System.out.println(tWall);
            if (!tWall.isEmpty()) {
                boardRep = boardRep + tWall.substring(0,1);
                tWall = tWall.substring(1);
            }
            else {
                boardRep = boardRep + '.';
            }
        }
        boardRep = boardRep + "\n";
        for (int l = 0; l < 20; l++) {
            if (!lWall.isEmpty()) {
                boardRep = boardRep + lWall.substring(0, 1) ;
                lWall = lWall.substring(1);
            }
            else {
                boardRep = boardRep +'.';
            }
            for (int m = 0; m < 20; m++) {
                boardRep = boardRep + boardArray[m][l];
            }
            if (!rWall.isEmpty()) {
                boardRep = boardRep + rWall.substring(0, 1) ;
                rWall = rWall.substring(1);
            }
            else {
                boardRep = boardRep +'.';
            }
            
            boardRep = boardRep + "\n";
        }
        
        for (int g = 0; g < 22; g++) {
            if (!bWall.isEmpty()) {
                boardRep = boardRep + bWall.substring(0,1);
                bWall = bWall.substring(1);
            }
            else {
                boardRep = boardRep + '.';
            }
        }
        boardRep = boardRep + "\n";
        return boardRep;
    }

    /**
     * ensure the rep invariant of Board is preserved
     */
    public boolean checkRep() {
        //TODO write this
    	return true;
    }
    /**@author ahochstadt
     * creates a wall that was previously connected to another board
     * @param wallLocation should be "left"|"right"|"up"|"down"
     */
    public void wallify(String wallLocation){
    	if(wallLocation.equals("left")){
    		this.leftWall.wallify();
    		this.setLeftWallSolid(true);
    		this.setLeftWallName("");
    	} else if(wallLocation.equals("up")){
    		this.upWall.wallify();
    		this.setUpWallSolid(true);
    		this.setUpWallName("");
    	} else if(wallLocation.equals("right")){
    		this.rightWall.wallify();
    		this.setRightWallSolid(true);
    		this.setRightWallName("");
    	}  else if(wallLocation.equals("down")){
    		this.downWall.wallify();
    		this.setRightWallSolid(true);
    		this.setRightWallName("");
    	}
    }
    /**@author ahochstadt
     * connects a wall to a board
     * @param wallLocation should be "left"|"right"|"up"|"down"
     * @param connectedBoardName is the name of the board the wall is being connected to ex. "Mars". If the connected board has no name, pass in the empty string ""
     */
    public void connectWall(String wallLocation, String connectedBoardName){
    	if(wallLocation.equals("left")){
    		this.leftWall.connectWall(connectedBoardName);
    		this.setLeftWallSolid(false);
    		this.setLeftWallName(connectedBoardName);
    	} else if(wallLocation.equals("up")){
    		this.upWall.connectWall(connectedBoardName);
    		this.setUpWallSolid(false);
    		this.setUpWallName(connectedBoardName);
    	} else if(wallLocation.equals("right")){
    		this.rightWall.connectWall(connectedBoardName);
    		this.setRightWallSolid(false);
    		this.setRightWallName(connectedBoardName);
    	}  else if(wallLocation.equals("down")){
    		this.downWall.connectWall(connectedBoardName);
    		this.setRightWallSolid(false);
    		this.setRightWallName(connectedBoardName);
    	}
    }
    
    public String getBoardName(){
    	return this.boardName;
    }
	public boolean isLeftWallSolid() {
		return leftWallSolid;
	}
	public void setLeftWallSolid(boolean leftWallSolid) {
		this.leftWallSolid = leftWallSolid;
	}
	public boolean isUpWallSolid() {
		return upWallSolid;
	}
	public void setUpWallSolid(boolean upWallSolid) {
		this.upWallSolid = upWallSolid;
	}
	public boolean isDownWallSolid() {
		return downWallSolid;
	}
	public void setDownWallSolid(boolean downWallSolid) {
		this.downWallSolid = downWallSolid;
	}
	public boolean isRightWallSolid() {
		return rightWallSolid;
	}
	public void setRightWallSolid(boolean rightWallSolid) {
		this.rightWallSolid = rightWallSolid;
	}
	public String getDownWallName() {
		return downWallName;
	}
	public void setDownWallName(String downWallName) {
		this.downWallName = downWallName;
	}
	public String getUpWallName() {
		return upWallName;
	}
	public void setUpWallName(String upWallName) {
		this.upWallName = upWallName;
	}
	public String getRightWallName() {
		return rightWallName;
	}
	public void setRightWallName(String rightWallName) {
		this.rightWallName = rightWallName;
	}
	public String getLeftWallName() {
		return leftWallName;
	}
	public void setLeftWallName(String leftWallName) {
		this.leftWallName = leftWallName;
	}
	public Wall getLeftWall() {
		return leftWall;
	}
	public void setLeftWall(Wall leftWall) {
		this.leftWall = leftWall;
	}
	public Wall getUpWall() {
		return upWall;
	}
	public void setUpWall(Wall upWall) {
		this.upWall = upWall;
	}
	public Wall getRightWall() {
		return rightWall;
	}
	public void setRightWall(Wall rightWall) {
		this.rightWall = rightWall;
	}
	public Wall getDownWall() {
		return downWall;
	}
	public void setDownWall(Wall downWall) {
		this.downWall = downWall;
	}
	public ConcurrentHashMap<String, Gadget> getTriggerMap(){
		return this.triggerMap;
	}

	public ArrayList<Ball> getOutgoingBalls() {
		return outgoingBalls;
	}

	public void setOutgoingBalls(ArrayList<Ball> outgoingBalls) {
		this.outgoingBalls = outgoingBalls;
	}

}
