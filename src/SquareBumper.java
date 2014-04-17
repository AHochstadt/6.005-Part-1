import java.util.ArrayList;

import physics.*;
/**
 * 
 * @author Lauren 
 *
 *A square shape with an edge length 1L.  Constructor takes two opposite corners as inputs 
 * A square shape with an edge length 1L.  
 *
 * Rep Invariant: edges of length 1L
 *                position is fixed
 */
public class SquareBumper extends Bumper {
	Board parentBoard = null;
    LineSegment side1;
    LineSegment side2;
    LineSegment side3;
    LineSegment side4;
    ArrayList<LineSegment> sides = new ArrayList<LineSegment>();
    Circle corner1;
    Circle corner2;
    Circle corner3;
    Circle corner4;
    ArrayList<Circle> corners = new ArrayList<Circle>();
    String name;
    double x;
    double y;
	private ArrayList<Object> physicsObjects;
    /**
     * Constructor for Square Bumper
     * @author ahochstadt
     * @param parentBoard the board that this bumper exists in
     * @param x x-coordinate of bumper (should be natural number)
     * @param y y-coordinate of bumper (should be natural number)
     * @param name name of bumper
     */
    SquareBumper(int x, int y, String name){
    	this.x = (double) x;
    	this.y = (double) y;
    	this.name = name;
    	this.corner1 = new Circle((double) x, (double) y, 0.0); //creates the line segments and corners starting at (x,y) and going around in a clockwise fashion
    	this.side1 = new LineSegment((double) x, (double) y, (double) x+1, (double) y);
    	this.corner2 = new Circle((double) x+1, (double) y, 0.0);
    	this.side2 = new LineSegment((double) x+1, (double) y, (double) x+1, (double) y+1);
    	this.corner3 = new Circle((double) x+1, (double) y+1, 0.0);
    	this.side3 = new LineSegment((double) x+1, (double) y+1, x, (double) y+1);
    	this.corner4 = new Circle((double) x, (double) y+1, 0.0);
    	this.side4 = new LineSegment((double) x, (double) y, (double) x, (double) y+1);
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
    
    public double getX() {
		return this.x;
	}
    
    public double getY() {
		return this.y;
	}
    
    @Override
	public ArrayList<Object> getPhysicsObjects() {
		return this.physicsObjects;
	}

    @Override 
    public String getName() {
        return this.name;
    }
    
    @Override
    public void setParentBoard(Board parent) {
        this.parentBoard = parent;
    }

	/**
     * ensure the rep invariant of Square Bumper is preserved
     */
    @Override
    public boolean checkRep() {
    	//TODO write this
        return true;
    }

}
