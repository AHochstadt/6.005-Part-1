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
    double x;
    double y;
    double orientation;
	private Board parentBoard = null;
	private String name;
	private ArrayList<Object> physicsObjects;
	private double angularVelocity = 1080; 
	private double reflectionCoeff =0.95; //default
	private boolean flipped = false; //whether the flipper is in the flipped position
	private boolean notFlipped = true; //whether the flipper is in the notFlipped position. We need notFlipped AND flipped because if the flipper is in motion, both are false
	private boolean flipping = false;
	private boolean flippingBack = false;
    
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
    	this.x = (double) x; 
    	this.y = (double) y;
        this.physicsObjects = new ArrayList<Object>();
    	this.setName(name);
    	if (orientation == 0){
    		this.flipper = new LineSegment((double) x,(double) 20.0-y,(double) x, (double) 20.0-(y+2));
    		this.pivot = new Circle((double) x,(double) 20.0-y, 0.0);
    		this.endPoint = new Circle((double) x, (double) 20.0-(y+2), 0.0);
    	} else if (orientation == 90){
    		this.flipper = new LineSegment((double) x,(double) 20.0-y,(double) x+2, (double) 20.0-y);
    		this.pivot = new Circle((double) x+2,(double) 20.0-y, 0.0);
    		this.endPoint = new Circle((double) x, (double) 20.0-y, 0.0);
    	} else if (orientation == 180){
    		this.flipper = new LineSegment((double) x+2,(double) 20.0-y,(double) x+2, (double) 20.0-(y+2));
    		this.pivot = new Circle((double) x+2,(double) 20.0-(y+2), 0.0);
    		this.endPoint = new Circle((double) x+2, (double) 20.0-y, 0.0);
    	} else {
    		if (orientation != 270){
    			throw new IOException("Invalid orientation");
    		}
    		this.flipper = new LineSegment((double) x,(double) 20.0-(y+2),(double) x+2, (double) 20.0-(y+2));
    		this.pivot = new Circle((double) x,(double) 20.0-(y+2), 0.0);
    		this.endPoint = new Circle((double) x+2, (double) 20.0-(y+2), 0.0);
    	}
    	this.physicsObjects.add(this.endPoint); this.physicsObjects.add(this.pivot); this.physicsObjects.add(this.flipper);
    }
    /**
     * moves the moving end of the flipper
     * flipper will move at a constant rotational velocity to be 90 degrees away from its starting position.  
     * flipper will never move outside of the bounding box 
     */
    public void move() {
    	if (this.flipped){
    		this.flipped = false;
    		this.flippingBack =true;
    		this.flipping = false; //this should already be false, but just in case
    		this.notFlipped = false; //this should already be false, but just in case
    	} else if (this.notFlipped){
    		this.notFlipped = false;
    		this.flipping =true;
    		this.flippingBack = false; //this should already be false, but just in case
    		this.flipped = false; //this should already be false, but just in case
    	}
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
		if (this.flipping){
			if (objectHit instanceof LineSegment){//we've hit the flipper
				LineSegment segmentHit = (LineSegment) objectHit;
				Vect newVel = Geometry.reflectRotatingWall(segmentHit, this.pivot.getCenter(), this.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity(), this.reflectionCoeff);
				b.setPhysicsPackageVelocity(newVel);
			} else if (objectHit instanceof Circle){
				Circle circleHit = (Circle) objectHit;
				Vect newVel = Geometry.reflectRotatingCircle(circleHit, this.pivot.getCenter(), this.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity(), this.reflectionCoeff); //if objectHit is our pivot, then we're rotating our pivot around our pivot, which is fine
				b.setPhysicsPackageVelocity(newVel);
			}
		} else if (this.flippingBack){
			if (objectHit instanceof LineSegment){//we've hit the flipper
				LineSegment segmentHit = (LineSegment) objectHit;
				Vect newVel = Geometry.reflectRotatingWall(segmentHit, this.pivot.getCenter(), (-1)*this.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity(), this.reflectionCoeff);
				b.setPhysicsPackageVelocity(newVel);
			} else if (objectHit instanceof Circle){
				Circle circleHit = (Circle) objectHit;
				Vect newVel = Geometry.reflectRotatingCircle(circleHit, this.pivot.getCenter(), (-1)*this.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity(), this.reflectionCoeff); //if objectHit is our pivot, then we're rotating our pivot around our pivot, which is fine
				b.setPhysicsPackageVelocity(newVel);
			}
		} else {
			if (objectHit instanceof LineSegment){//we've hit the flipper
				LineSegment segmentHit = (LineSegment) objectHit;
				Vect newVel = Geometry.reflectRotatingWall(segmentHit, this.pivot.getCenter(), 0.0, b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity(), this.reflectionCoeff);
				b.setPhysicsPackageVelocity(newVel);
			} else if (objectHit instanceof Circle){
				Circle circleHit = (Circle) objectHit;
				Vect newVel = Geometry.reflectRotatingCircle(circleHit, this.pivot.getCenter(), 0.0, b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity(), this.reflectionCoeff); //if objectHit is our pivot, then we're rotating our pivot around our pivot, which is fine
				b.setPhysicsPackageVelocity(newVel);
			}
		}
		
	}
	/**
     * @author ahochstadt
     * gets the triggered gadget and triggers its action
     */
    @Override
	public void trigger() {
    	Gadget triggeredGadget = this.parentBoard.getTriggerMap().get(this.name);
    	if (triggeredGadget != null) {
    	    triggeredGadget.action();
    	}

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
    @Override
    public boolean isFlipped(){
    	return this.flipped;
    }
    @Override
    public double getOrientation() {
        return this.orientation;
    }
    @Override
	public boolean isFlipping() {
		return flipping;
	}
    @Override
	public void setFlipping(boolean flipping) {
		this.flipping = flipping;
	}
    @Override
	public boolean isFlippingBack() {
		return flippingBack;
	}
    @Override
	public void setFlippingBack(boolean flippingBack) {
		this.flippingBack = flippingBack;
	}
	@Override
	public Circle getPivot() {
		return this.pivot;
	}
	@Override
	public double getAngularVelocity() {
		return this.angularVelocity;
	}
	@Override
	public Circle getEndpt() {
		return this.endPoint;
	}
	@Override
	public boolean inBoundingBox(Circle proposedEndpt) {
		double propX = proposedEndpt.getCenter().x();
		double propY = 20.0-proposedEndpt.getCenter().y();
		return ((propX<=this.x+2.0) && (propY<=this.y+2.0) && (propX>=this.x) && (propX>=this.x)); //proposed endpoints lie in the bounding box
	}
	@Override
	public void moveFlipper(double timestep) {
		Circle proposedEndpt = new Circle(this.endPoint.getCenter().x(), this.endPoint.getCenter().y(), 0.0); //initiallizes to copy of current Endpoint
		if (this.flipping) { //left flipper moving in the +theta direction
			proposedEndpt = Geometry.rotateAround(this.getEndpt(), getPivot().getCenter(), new Angle(this.angularVelocity*timestep));
			if (this.inBoundingBox(proposedEndpt)){
				this.endPoint = new Circle(proposedEndpt.getCenter().x(), proposedEndpt.getCenter().y(), 0.0);
			} else {
				this.flipped = true;
				this.flipping = false;
				this.notFlipped = false; //shouldn't be necessary but it doesn't hurt
				this.flippingBack = false; //shouldn't be necessary but it doesn't hurt
				if (this.orientation == 0.0){
					this.endPoint = new Circle(this.x+2, 20-this.y, 0.0);
				} else if (this.orientation == 90.0){
					this.endPoint = new Circle(this.x+2, 20-(this.y+2), 0.0);
				} else if (this.orientation == 180.0){
					this.endPoint = new Circle(this.x, 20-(this.y+2), 0.0);
				} else if (this.orientation == 270.0){ //should be the last possibility
					this.endPoint = new Circle(this.x, 20-(this.y), 0.0);
				}
			}
		} else if (this.flippingBack) { //left flipper moving in the -theta direction
			proposedEndpt = Geometry.rotateAround(this.getEndpt(), getPivot().getCenter(), new Angle((-1)*this.angularVelocity*timestep));
			if (this.inBoundingBox(proposedEndpt)){
				this.endPoint = new Circle(proposedEndpt.getCenter().x(), proposedEndpt.getCenter().y(), 0.0);
			} else {
				this.notFlipped = true;
				this.flippingBack = false;
				this.notFlipped = false; //shouldn't be necessary but it doesn't hurt
				this.flipping = false; //shouldn't be necessary but it doesn't hurt
				if (this.orientation == 0.0){
					this.endPoint = new Circle(this.x, 20-(this.y+2), 0.0);
				} else if (this.orientation == 90.0){
					this.endPoint = new Circle(this.x, 20-(this.y), 0.0);
				} else if (this.orientation == 180.0){
					this.endPoint = new Circle(this.x+2, 20-(this.y), 0.0);
				} else if (this.orientation == 270.0){ //should be the last possibility
					this.endPoint = new Circle(this.x+2, 20-(this.y+2), 0.0);
				}
			}
		}
		this.flipper = new LineSegment(this.endPoint.getCenter().x(), this.endPoint.getCenter().y(), this.pivot.getCenter().x(), this.pivot.getCenter().y());
	}
}
