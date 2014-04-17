import java.util.ArrayList;

import physics.*;
/**
 * 
 * @author Lauren 
 * 
 * A circular shape with diameter 1L 
 *
 * Rep Invariant: position is fixed
 *
 */
public class CircularBumper extends Bumper{
    
    Vect center;
    Circle circleRep;
    Double x;
    Double y;
	private Board parentBoard;
	private String name;
	private ArrayList<Object> physicsObjects;
	/**
     * @author ahochstadt
     * @author Lauren
     * Constructor for Circular Bumper
     * @param x x-coordinate of upper-left corner of bumper square (should be natural number)
     * @param y y-coordinate of upper-left corner of bumper square (should be natural number)
     * @param name name of the bumper
     */
    CircularBumper(double x, double y, String name) {
    	this.name = name;
        this.x = x;
        this.y = y;
        //make sure to keep the +.5 in the lines below or make sure to keep the inputs to Vect and Circle doubles somehow
        this.center = new Vect(x+.5,y+.5); //+.5 because (x, y) specifies the upper left corner of the gadget
        this.circleRep = new Circle(x+.5,y+.5,0.5); //+.5 because (x, y) specifies the upper left corner of the gadget
        this.physicsObjects.add(circleRep);
        }
    
    
    /**
     * ensure the rep invariant of Circular Bumper is preserved
     */
    @Override
    public boolean checkRep() {
    	//TODO write this method
        return true;
    }
    
    @Override 
    public String getName() {
        return this.name;
    }
    
	public Board getParentBoard() {
		return parentBoard;
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

	public void setParentBoard(Board parent) {
	    this.parentBoard = parent;
	}

	@Override
	public ArrayList<Object> getPhysicsObjects() {
		return physicsObjects;
	}

}
