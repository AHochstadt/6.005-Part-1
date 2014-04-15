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
    
    CircularBumper(double x, double y) {
        this.center = new Vect(x,y);
        this.circleRep = new Circle(x,y,0.5);
        
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