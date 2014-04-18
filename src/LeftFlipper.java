import java.io.IOException;
import java.util.ArrayList;

import physics.*;
/**
 * 
 * @author Lauren 
 * @author ahochstadt
 * A class representing a left flipper
 * 
 * Rep Invariant: flipper remains within the bounding box
 *                stationary end of Left Flipper is fixed
 *
 */
public class LeftFlipper implements Flipper{
	Circle pivot;
	Circle endPoint;
    LineSegment flipper;
    double orientation;
	private Board parentBoard = null;
	private String name;
	private ArrayList<Object> physicsObjects;
	private double angularVelocity = 0.0; //starts at rest
	private double reflectionCoeff =0.95; //default
	private boolean flipped = false; //whether the flipper is in the flipped position
	private boolean notFlipped = true; //whether the flipper is in the notFlipped position. We need notFlipped AND flipped because if the flipper is in motion, both are false
	
    
    /**
     * Constructor for Left Flipper
     * @author ahochstadt
     * @param x x-coordinate for upperleft corner of 2Lx2L bounding box
     * @param y y-coordinate for upperleft corner of 2Lx2L bounding box
     * @param orientation can be 0|90|180|270. Measure (in degrees) of how much the original flipper bumper is rotated. Original bumper (orientation = 0) lies on the west side of the bounding box.
     * @param name name of the flipper
     * @param parentBoard 
     * @throws IOException if orientation does not equal 0|90|180|270
     */
    LeftFlipper(int x, int y, int orientation, String name) throws IOException {
        this.physicsObjects = new ArrayList<Object>();
    	this.setName(name);
    	if (orientation == 0){
    		this.flipper = new LineSegment((double) x,(double) y,(double) x, (double) y+2);
    		this.pivot = new Circle((double) x,(double) y, 0.0);
    		this.endPoint = new Circle((double) x, (double) y+2, 0.0);
    	} else if (orientation == 90){
    		this.flipper = new LineSegment((double) x,(double) y,(double) x+2, (double) y);
    		this.pivot = new Circle((double) x+2,(double) y, 0.0);
    		this.endPoint = new Circle((double) x, (double) y, 0.0);
    	} else if (orientation == 180){
    		this.flipper = new LineSegment((double) x+2,(double) y,(double) x+2, (double) y+2);
    		this.pivot = new Circle((double) x+2,(double) y+2, 0.0);
    		this.endPoint = new Circle((double) x+2, (double) y, 0.0);
    	} else {
    		if (orientation != 270){
    			throw new IOException("Invalid orientation");
    		}
    		this.flipper = new LineSegment((double) x,(double) y+2,(double) x+2, (double) y+2);
    		this.pivot = new Circle((double) x,(double) y+2, 0.0);
    		this.endPoint = new Circle((double) x+2, (double) y+2, 0.0);
    	}
    	this.physicsObjects.add(this.endPoint); this.physicsObjects.add(this.pivot); this.physicsObjects.add(this.flipper);
    }
    /**
     * moves the moving end of the flipper
     * flipper will move at a constant rotational velocity to be 90 degrees away from its starting position.  
     * flipper will never move outside of the bounding box 
     */
    public void move() {
        Geometry.rotateAround(this.flipper, new Vect(this.pivot.getCenter().x(), this.pivot.getCenter().y()), new Angle(90));
        Geometry.rotateAround(this.endPoint, new Vect(this.pivot.getCenter().x(), this.pivot.getCenter().y()), new Angle(90));
    }
    
    
    /**
     * 
     * @return fixed x value 
     */
    public double getFixedX() {
        return this.pivot.getCenter().x();
    }

    /**
     * 
     * @return moving y value 
     */
    public double getFixedY() {
        return this.pivot.getCenter().y();
        
    }
    
    /**
     * 
     * @return moving x value 
     */
    public double getMovingX() {
        return this.endPoint.getCenter().x();
        
    }
    
    /**
     * 
     * @return moving x value 
     */
    public double getMovingY() {
    	return this.endPoint.getCenter().y();
    }
   
    
    /**
     * ensure the rep invariant of Left Flipper is preserved.  Inside bounding box, with moving end, never further away than 2L from origin 
     */
    public boolean checkRep() {
    	//TODO write this
        return true;
    }
	
	
	@Override
	public void getEffect(Ball b, Object objectHit) {
		if (objectHit instanceof LineSegment){//we've hit the flipper
			LineSegment segmentHit = (LineSegment) objectHit;
			Vect newVel = Geometry.reflectRotatingWall(segmentHit, this.pivot.getCenter(), this.angularVelocity, b.getCircle(), b.getVelocity(), this.reflectionCoeff);
			b.setVelocity(newVel);
		} else if (objectHit instanceof Circle){
			Circle circleHit = (Circle) objectHit;
			Vect newVel = Geometry.reflectRotatingCircle(circleHit, this.pivot.getCenter(), this.angularVelocity, b.getCircle(), b.getVelocity(), this.reflectionCoeff); //if objectHit is our pivot, then we're rotating our pivot around our pivot, which is fine
			b.setVelocity(newVel);
		}
		
	}
	/**
     * @author ahochstadt
     * gets the triggered gadget and triggers its action
     */
    @Override
	public void trigger() {
    	Gadget triggeredGadget = this.parentBoard.getTriggerMap().get(this.name);
    	triggeredGadget.action();
	}
	@Override
	public void action() {
		this.move();
		
	}
	@Override
	public ArrayList<Object> getPhysicsObjects() {
		return this.physicsObjects;
	}

	@Override
	public Board getParentBoard() {
		return this.parentBoard;
	}
	
	@Override
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
    @Override
    public void setParentBoard(Board parent) {
        this.parentBoard = parent;
        
    }
    
    public boolean isFlipped(){
    	return this.flipped;
    }


}
