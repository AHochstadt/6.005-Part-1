import java.io.IOException;
import java.util.ArrayList;

import physics.*;
/**
 * 
 * @author Lauren 
 * @author ahochstadt
 * 
 * A right-triangle shaped bumper 
 * 
 * Rep Invariant: sides of 1L and hypotenuse of length Sqrt(2)L
 *                position is fixed
 *
 */
public class TriangularBumper extends Bumper {
    LineSegment side1;
    LineSegment side2;
    LineSegment side3;
    ArrayList<LineSegment> sides;
    Circle corner1;
    Circle corner2;
    Circle corner3;
    ArrayList<Circle> corners;
    double x;
    double y;
    double orientation;
    String name;
	private Board parentBoard;
	private ArrayList<Object> physicsObjects;

    
    /**
     * Constructor for Triangular Bumper
     * @author ahochstadt
     * @param x x-coordinate of upper-left corner of bumper square
     * @param y y-coordinate of upper-left corner of bumper square
     * @param orientation can be 0|90|180|270. Measure (in degrees) of how much the original triangular bumper is rotated. Original bumper (orientation = 0) has legs on the north and west sides of the square.
     * @param name name of the bumper
     * @throws IOException if orientation != 0|90|180|270
     */
    TriangularBumper(int x, int y, int orientation, String name) throws IOException{
    	this.x = (double) x;
    	this.y = (double) y;
    	this.orientation = (double) orientation;
    	this.name = name;
    	this.sides = new ArrayList<LineSegment>();
    	this.corners = new ArrayList<Circle>();
    	this.physicsObjects = new ArrayList<Object>();
    	
    	if (orientation == 0){
    		side1 = new LineSegment(this.x, this.y+1, this.x, this.y);
    		corner1 = new Circle(this.x, this.y, 0.0);
    		side2 = new LineSegment(this.x, this.y, this.x+1, this.y);
    		corner2 = new Circle(this.x+1, this.y, 0.0);
    		side3 = new LineSegment(this.x+1, this.y, this.x, this.y+1);
    		corner3 = new Circle(this.x, this.y+1, 0.0);
    	} else if (orientation == 90){
    		side1 = new LineSegment(this.x, this.y, this.x+1, this.y);
    		corner1 = new Circle(this.x+1, this.y, 0.0);
    		side2 = new LineSegment(this.x+1, this.y, this.x+1, this.y+1);
    		corner2 = new Circle(this.x+1, this.y+1, 0.0);
    		side3 = new LineSegment(this.x, this.y, this.x+1, this.y+1);
    		corner3 = new Circle(this.x, this.y, 0.0);
    	} else if (orientation == 180){
    		side1 = new LineSegment(this.x, this.y+1, this.x+1, this.y);
    		corner1 = new Circle(this.x+1, this.y, 0.0);
    		side2 = new LineSegment(this.x+1, this.y, this.x+1, this.y+1);
    		corner2 = new Circle(this.x+1, this.y+1, 0.0);
    		side3 = new LineSegment(this.x, this.y+1, this.x+1, this.y+1);
    		corner3 = new Circle(this.x, this.y+1, 0.0);
    	} else {
    		if (orientation != 270){
    			throw new IOException("Invalid orientation");
    		}
    		side1 = new LineSegment(this.x, this.y, this.x+1, this.y+1);
    		corner1 = new Circle(this.x+1, this.y+1, 0.0);
    		side2 = new LineSegment(this.x+1, this.y+1, this.x, this.y+1);
    		corner2 = new Circle(this.x, this.y+1, 0.0);
    		side3 = new LineSegment(this.x, this.y+1, this.x, y);
    		corner3 = new Circle(this.x, this.y, 0.0);
    	}
    	this.sides.clear();
    	this.sides.add(this.side1); this.sides.add(this.side2); this.sides.add(this.side3); //populate this.sides
    	this.corners.clear();
    	this.corners.add(this.corner1); this.corners.add(this.corner2); this.corners.add(this.corner3); //populate this.corners
    	this.physicsObjects.add(this.corner1); this.physicsObjects.add(this.corner2); this.physicsObjects.add(this.corner3); this.physicsObjects.add(this.side1); this.physicsObjects.add(this.side2); this.physicsObjects.add(this.side3); //populate physicsObjects
    	
    	
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

	public void action() { //does nothing by definition of Bumper
	}

    public String getName() {
        return this.name;
    }
    
    @Override
    public void setParentBoard(Board parent) {
        this.parentBoard = parent;
    }
    
    /**
     * ensure the rep invariant of Triangular Bumper is preserved
     */
    public boolean checkRep() {
    	//TODO write this
        return true;
        
    }
    @Override
    public ArrayList<Object> getPhysicsObjects(){
    	return this.physicsObjects;
    }


    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }

}
