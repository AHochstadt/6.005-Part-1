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
    String name;
	private Board parentBoard = null;
    
    CircularBumper(double x, double y, String name) {
    	this.name = name;
        this.x = x;
        this.y = y;
        this.center = new Vect(x,y);
        this.circleRep = new Circle(x,y,0.5);
        }
    /**
     * @author ahochstadt
     * @author Lauren
     * Constructor for Circular Bumper
     * @param x x-coordinate of upper-left corner of bumper square (should be natural number)
     * @param y y-coordinate of upper-left corner of bumper square (should be natural number)
     * @param name name of the bumper
     */
    CircularBumper(int x, int y, String name) {
    	//make sure to keep the +.5 in the lines below or make sure to keep the inputs to Vect and Circle doubles somehow
        this.center = new Vect(x+.5,y+.5); //+.5 because (x, y) specifies the upper left corner of the gadget
        this.circleRep = new Circle(x+.5,y+.5,0.5); //+.5 because (x, y) specifies the upper left corner of the gadget
        
    }
    
    
    
    /**
     * 
     * @param b: Ball that the bumper is interacting with 
     * @effect: ball position remains unchanged.  Angle is changed to the reflection angle.  Velocity remains the same.  
     */
    public void getEffect(Ball b) {
        
        Vect newV = Geometry.reflectCircle(this.center, b.getVector(), b.getVector());
        b.setVelocity(newV);
        
    }
    
    /**
     * 
     * @param b: ball object to test if in bounds 
     * @return: true if the ball is in the space that is occupied by the bumper 
     * 
     */
    
    
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

	public void setParentBoard(Board parent) {
	    this.parentBoard = parent;
	}
}
