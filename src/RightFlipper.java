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
    	this.setName(name);
    	if (orientation == 0){
    		this.flipper = new LineSegment((double) x+2,(double) y,(double) x+2, (double) y+2);
    		this.pivot = new Circle((double) x+2,(double) y, 0.0);
    		this.endPoint = new Circle((double) x+2, (double) y+2, 0.0);
    	} else if (orientation == 90){
    		this.flipper = new LineSegment((double) x,(double) y+2,(double) x+2, (double) y+2);
    		this.pivot = new Circle((double) x+2,(double) y+2, 0.0);
    		this.endPoint = new Circle((double) x, (double) y+2, 0.0);
    	} else if (orientation == 180){
    		this.flipper = new LineSegment((double) x,(double) y,(double) x, (double) y+2);
    		this.pivot = new Circle((double) x,(double) y+2, 0.0);
    		this.endPoint = new Circle((double) x, (double) y, 0.0);
    	} else {
    		if (orientation != 270){
    			throw new IOException("Invalid orientation");
    		}
    		this.flipper = new LineSegment((double) x,(double) y,(double) x+2, (double) y);
    		this.pivot = new Circle((double) x,(double) y, 0.0);
    		this.endPoint = new Circle((double) x+2, (double) y, 0.0);
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
		// TODO Auto-generated method stub
		
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

}
