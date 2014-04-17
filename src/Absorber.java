import java.util.ArrayList;

import physics.Circle;
import physics.LineSegment;

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
	private Board parentBoard;
    /**
     * Constructor for Absorber
     * @author ahochstadt
     * @param x x-coordinate for upperleft corner of height x width absorber
     * @param y y-coordinate for upperleft corner of height x width absorber
     * @param width width of the absorber
     * @param height height of the absorber
     * @param name name of the absorber. Must be unique to the board file
     */
    Absorber(Board parentBoard, int x, int y, int width, int height, String name) {
    	this.parentBoard = parentBoard;
        this.x = (double) x;
        this.y = (double) y; 
        this.width = (double) width;
        this.height = (double) height;
        this.name = name;
        
        this.corner1 = new Circle((double) x, (double) y, 0.0); //creates the line segments and corners starting at (x,y) and going around in a clockwise fashion
    	this.side1 = new LineSegment((double) x, (double) y, (double) x+width, (double) y);
    	this.corner2 = new Circle((double) x+width, (double) y, 0.0);
    	this.side2 = new LineSegment((double) x+width, (double) y, (double) x+width, (double) y+height);
    	this.corner3 = new Circle((double) x+width, (double) y+height, 0.0);
    	this.side3 = new LineSegment((double) x+width, (double) y+height, x, (double) y+height);
    	this.corner4 = new Circle((double) x, (double) y+height, 0.0);
    	this.side4 = new LineSegment((double) x, (double) y, (double) x, (double) y+height);
    	this.sides.clear();
    	this.sides.add(this.side1); this.sides.add(this.side2); this.sides.add(this.side3); this.sides.add(this.side4); //populates this.sides
    	this.corners.clear();
    	this.corners.add(this.corner1); this.corners.add(this.corner2); this.corners.add(this.corner3); this.corners.add(this.corner4); //populates this.corners
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
     * ball will be removed from the board if absorber is not holding a ball (board.remove)
     * absorber will hold the ball
     * 
     * if the absorber is holding a ball, then this ball will shoot out of the absorber when a ball hits the absorber (board.add)
     * 
     * @param b
     */
    @Override
	public void getEffect(Ball b, Object objectHit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Object> getPhysicsObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return name;
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

	public Board getParentBoard() {
		return parentBoard;
	}





}
