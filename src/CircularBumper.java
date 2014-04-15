import java.lang.Object;


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
    
    /**
     * @author ahochstadt
     * @author Lauren
     * Constructor for Circular Bumper
     * @param x x-coordinate of upper-left corner of bumper square (should be natural number)
     * @param y y-coordinate of upper-left corner of bumper square (should be natural number)
     * @param name name of the bumper
     */
    CircularBumper(double x, double y, String name) {
        this.center = new Vect(x+.5,y+.5); //+.5 because (x, y) specifies the upper left corner of the gadget
        this.circleRep = new Circle(x+.5,y+.5,0.5); //+.5 because (x, y) specifies the upper left corner of the gadget
        
    }
    
    
    
    /**
     * 
     * @param b: Ball that the bumper is interacting with 
     * @effect: ball position remains unchanged.  Angle is changed to the reflection angle.  Velocity remains the same.  
     */
    public void getEffect(Ball b) {
        
        Vect newV = Geometry.reflectCircle(this.center, b.getVector(), b.getVelocity());
        b.setVelocity(newV);
        
    }
    
    /**
     * 
     * @param b: ball object to test if in bounds 
     * @return: true if the ball is in the space that is occupied by the bumper 
     * 
     */
    @Override
    public boolean inBounds(Ball b) {
        return false;
        //TODO
    }
    
    /**
     * ensure the rep invariant of Circular Bumper is preserved
     */
    private void checkRep() {
        
    }

}
