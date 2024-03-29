import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

/**
 * 
 * @author Lauren
 * @author ahochstadt
 * A class representing the Absorber
 * An absorber is a rectangle kL x mL 
 * 
 * Rep Invariant: k and m are positive integers <= 20 and >= 1
 *                position is fixed
 *
 */
public class Absorber implements Stationary {
    private double x;
    private double y;
    private double width;
    private double height;
    private String name;
	private Circle corner1;
	private Circle corner2;
	private Circle corner3;
	private Circle corner4;
	private LineSegment side1;
	private LineSegment side2;
	private LineSegment side3;
	private LineSegment side4;
	private ArrayList<LineSegment> sides = new ArrayList<LineSegment>();
	private ArrayList<Circle> corners = new ArrayList<Circle>();
	private Board parentBoard = null;
	private ArrayList<Object> physicsObjects = new ArrayList<Object>();
	private boolean isHoldingBall;
	private BlockingQueue<Ball> heldBalls = new LinkedBlockingQueue<Ball>();
    /**
     * Constructor for Absorber
     * @author ahochstadt
     * @param x x-coordinate for upperleft corner of height x width absorber
     * @param y y-coordinate for upperleft corner of height x width absorber
     * @param width width of the absorber
     * @param height height of the absorber
     * @param name name of the absorber. Must be unique to the board file
     */
    Absorber(int x, int y, int width, int height, String name) {
        this.x = (double) x;
        this.y = (double) y; 
        this.width = (double) width;
        this.height = (double) height;
        this.name = name;
        this.isHoldingBall = false;
        
        this.corner1 = new Circle((double) x, (double) 20.0-y, 0.0); //creates the line segments and corners starting at (x,y) and going around in a clockwise fashion
    	this.side1 = new LineSegment((double) x, (double) 20.0-y, (double) x+width, (double) 20.0-y);
    	this.corner2 = new Circle((double) x+width, (double) 20.0-y, 0.0);
    	this.side2 = new LineSegment((double) x+width, (double) 20.0-y, (double) x+width, (double) 20.0-(y+height));
    	this.corner3 = new Circle((double) x+width, (double) 20.0-(y+height), 0.0);
    	this.side3 = new LineSegment((double) x+width, (double) 20.0-(y+height), x, (double) 20.0-(y+height));
    	this.corner4 = new Circle((double) x, (double) 20.0-(y+height), 0.0);
    	this.side4 = new LineSegment((double) x, (double) 20.0-y, (double) x, (double) 20.0-(y+height));
    	this.sides.clear();
    	this.sides.add(this.side1); this.sides.add(this.side2); this.sides.add(this.side3); this.sides.add(this.side4); //populates this.sides
    	this.corners.clear();
    	this.corners.add(this.corner1); this.corners.add(this.corner2); this.corners.add(this.corner3); this.corners.add(this.corner4); //populates this.corners
    	for (Object physicsObject: this.corners){ //adds corners to physicsObjects
    		this.physicsObjects.add(physicsObject);
    	}
    	for (Object physicsObject: this.sides){ //adds sides to physicsObjects
    		this.physicsObjects.add(physicsObject);
    	}
    }
    
    /**
     * ensure the rep invariant of Absorber is preserved
     */
    public boolean checkRep() {
        return true;
    }
    
    public double getHeight() {
		return this.height;
	}

    public double getWidth() {
		return this.width;
	}

    public double getX() {
		return this.x;
	}
    
    public double getY() {
		return this.y;
	}
    
    /**
     * ball will be removed from the board if absorber is not holding a ball 
     * absorber will hold the ball
     * 
     * if the absorber is holding a ball, then this ball will shoot out of the absorber when a ball hits the absorber (board.add)
     * 
     * @param b
     */
    @Override
	public void getEffect(Ball b, Object objectHit) {
    	System.out.println("WE'RE IN GETEFFECT");
    	if (this.heldBalls.contains(b)) {
    	    //do nothing
    	}
    	
    	else if (!(b.getPhysicsPackageVelocity().y()>=30.0)){ //if upward velocity >= 0.0, then the ball is being shot out of the absorber or is being held in the absorber, sowe make sure that this is not the case
			b.setPhysicsPackageVelocity(new Vect(0.0, 0.0)); //stop the ball
			b.setBallVector(new Vect(this.x+this.width-.25,this.y+this.height-.25));
			b.inAbsorberQueue = true;
			try {
				this.heldBalls.put(b);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public ArrayList<Object> getPhysicsObjects() {
		return this.physicsObjects;
	}

	@Override
	public String getName() {
		return name;
	}

	/**
     * @author ahochstadt
     * gets the triggered gadget and triggers its action
     */
    @Override
	public void trigger() {
        System.out.println(this.parentBoard.getTriggerMap());
        Gadget triggeredGadget = this.parentBoard.getTriggerMap().get(this.name);
        System.out.println(triggeredGadget);
        if (triggeredGadget != null) {
            triggeredGadget.action();
        }
    }

	@Override
	public void action() { //shoots out a ball straight up at 50 L/sec, if the absorber is currently holding >= 1 ball
		if (!this.heldBalls.isEmpty()){
			try {
				Ball heldBall = this.heldBalls.take();
				heldBall.setPhysicsPackageVelocity(new Vect(0.0,50.0));
	            heldBall.setPhysicsPackageBallVector(new Vect(heldBall.getPhysicsPackageBallVector().x(), y-height));
	            heldBall.inAbsorberQueue = false;
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	public Board getParentBoard() {
		return parentBoard;
	}

    @Override
    public void setParentBoard(Board parent) {
        this.parentBoard = parent;
        
    }





}
