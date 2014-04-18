import java.io.IOException;
import java.util.ArrayList;

import physics.Angle;
import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

/**
 * 
 * @author Lauren 
 * 
 * A class representing a right flipper
 * 
 * Rep Invariant: flipper must never move outside of the bounding box 
 *
 */
public class RightFlipper implements Flipper{
	Circle pivot;
	Circle endPoint;
    LineSegment flipper;
    double orientation;
	private Board parentBoard = null;
	private String name;
	private ArrayList<Object> physicsObjects;
	private boolean flipped = false; //whether the flipper is in the flipped position
	private boolean notFlipped = true; //whether the flipper is in the notFlipped position. We need notFlipped AND flipped because if the flipper is in motion, both are false
	private double angularVelocity = 0.0; //starts at rest
	private double reflectionCoeff =0.95; //default
	private boolean flipping;
	private boolean flippingBack;
	private double x;
	private double y;
    
    /**
     * Constructor for Right Flipper
     * @author ahochstadt
     * @param x x-coordinate for upperleft corner of 2Lx2L bounding box
     * @param y y-coordinate for upperleft corner of 2Lx2L bounding box
     * @param orientation can be 0|90|180|270. Measure (in degrees) of how much the original flipper bumper is rotated. Original bumper (orientation = 0) lies on the east side of the bounding box.
     * @param name name of the flipper
     * @throws IOException if orientation != 0|90|180|270
     */
    RightFlipper(int x, int y, int orientation, String name) throws IOException {
    	this.x = (double) x;
    	this.y = (double) y;
    	
    	this.setName(name);
    	this.physicsObjects = new ArrayList<Object>();
    	if (orientation == 0){
    		this.flipper = new LineSegment((double) x+2,(double) 20.0-y,(double) x+2, (double) 20.0-(y+2));
    		this.pivot = new Circle((double) x+2,(double) 20.0-y, 0.0);
    		this.endPoint = new Circle((double) x+2, (double) 20.0-(y+2), 0.0);
    	} else if (orientation == 90){
    		this.flipper = new LineSegment((double) x,(double) 20.0-(y+2),(double) x+2, (double) 20.0-(y+2));
    		this.pivot = new Circle((double) x+2,(double) 20.0-(y+2), 0.0);
    		this.endPoint = new Circle((double) x, (double) 20.0-(y+2), 0.0);
    	} else if (orientation == 180){
    		this.flipper = new LineSegment((double) x,(double) 20.0-y,(double) x, (double) 20.0-(y+2));
    		this.pivot = new Circle((double) x,(double) 20.0-(y+2), 0.0);
    		this.endPoint = new Circle((double) x, (double) 20.0-y, 0.0);
    	} else {
    		if (orientation != 270){
    			throw new IOException("Invalid orientation");
    		}
    		this.flipper = new LineSegment((double) x,(double) 20.0-y,(double) x+2, (double) 20.0-y);
    		this.pivot = new Circle((double) x,(double) 20.0-y, 0.0);
    		this.endPoint = new Circle((double) x+2, (double) 20.0-y, 0.0);
    	}
    	this.physicsObjects.add(this.endPoint); this.physicsObjects.add(this.pivot); this.physicsObjects.add(this.flipper);

    }
    /**
     * moves the moving end of the flipper
     * flipper will move at a constant rotational velocity to be 90 degrees away from its starting position.  
     * flipper will never move outside of the bounding box 
     */
    public void move() {
        //Geometry.rotateAround(this.flipper, new Vect(this.pivot.getCenter().x(), this.pivot.getCenter().y()), new Angle(90));
        //update xMov and yMov
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
     * ensure the rep invariant of Right Flipper is preserved
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
				Vect newVel = Geometry.reflectRotatingWall(segmentHit, this.pivot.getCenter(), (-1)*this.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity(), this.reflectionCoeff);
				b.setPhysicsPackageVelocity(newVel);
			} else if (objectHit instanceof Circle){
				Circle circleHit = (Circle) objectHit;
				Vect newVel = Geometry.reflectRotatingCircle(circleHit, this.pivot.getCenter(), (-1)*this.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity(), this.reflectionCoeff); //if objectHit is our pivot, then we're rotating our pivot around our pivot, which is fine
				b.setPhysicsPackageVelocity(newVel);
			}
		} else if (this.flippingBack){
			if (objectHit instanceof LineSegment){//we've hit the flipper
				LineSegment segmentHit = (LineSegment) objectHit;
				Vect newVel = Geometry.reflectRotatingWall(segmentHit, this.pivot.getCenter(), this.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity(), this.reflectionCoeff);
				b.setPhysicsPackageVelocity(newVel);
			} else if (objectHit instanceof Circle){
				Circle circleHit = (Circle) objectHit;
				Vect newVel = Geometry.reflectRotatingCircle(circleHit, this.pivot.getCenter(), this.getAngularVelocity(), b.getPhysicsPackageCircle(), b.getPhysicsPackageVelocity(), this.reflectionCoeff); //if objectHit is our pivot, then we're rotating our pivot around our pivot, which is fine
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
		// TODO Auto-generated method stub
		
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
    public ArrayList<Object> getPhysicsObjects(){
    	return this.physicsObjects;
    }
    
    public boolean isFlipped(){
    	return this.flipped;
    }
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
		if (this.flipping) { //right flipper moving in the -theta direction
			proposedEndpt = Geometry.rotateAround(this.getEndpt(), getPivot().getCenter(), new Angle((-1)*this.angularVelocity*timestep));
			if (this.inBoundingBox(proposedEndpt)){
				this.endPoint = new Circle(proposedEndpt.getCenter().x(), proposedEndpt.getCenter().y(), 0.0);
			} else { //TODO fix below right
				this.flipped = true;
				this.flipping = false;
				this.notFlipped = false; //shouldn't be necessary but it doesn't hurt
				this.flippingBack = false; //shouldn't be necessary but it doesn't hurt
				if (this.orientation == 0.0){
					this.endPoint = new Circle(this.x, 20-(this.y), 0.0);
				} else if (this.orientation == 90.0){
					this.endPoint = new Circle(this.x+2, 20-(this.y), 0.0);
				} else if (this.orientation == 180.0){
					this.endPoint = new Circle(this.x+2, 20-(this.y+2), 0.0);
				} else if (this.orientation == 270.0){ //should be the last possibility
					this.endPoint = new Circle(this.x, 20-(this.y+2), 0.0);
				}
			}
		} else if (this.flippingBack) { //right flipper moving in the +theta direction
			proposedEndpt = Geometry.rotateAround(this.getEndpt(), getPivot().getCenter(), new Angle(this.angularVelocity*timestep));
			if (this.inBoundingBox(proposedEndpt)){
				this.endPoint = new Circle(proposedEndpt.getCenter().x(), proposedEndpt.getCenter().y(), 0.0);
			} else {
				this.notFlipped = true;
				this.flippingBack = false;
				this.flipped = false; //shouldn't be necessary but it doesn't hurt
				this.flipping = false; //shouldn't be necessary but it doesn't hurt
				if (this.orientation == 0.0){
					this.endPoint = new Circle(this.x+2, 20-(this.y+2), 0.0);
				} else if (this.orientation == 90.0){
					this.endPoint = new Circle(this.x, 20-(this.y+2), 0.0);
				} else if (this.orientation == 180.0){
					this.endPoint = new Circle(this.x, 20-(this.y), 0.0);
				} else if (this.orientation == 270.0){ //should be the last possibility
					this.endPoint = new Circle(this.x+2, 20-(this.y), 0.0);
				}
			}
		}
		this.flipper = new LineSegment(this.endPoint.getCenter().x(), this.endPoint.getCenter().y(), this.pivot.getCenter().x(), this.pivot.getCenter().y());
	}

}
