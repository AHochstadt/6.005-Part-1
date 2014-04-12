
/**
 * 
 * @author Lauren 
 * 
 * A right-triangle shaped bumper with sides of 1L and hypotenuse of length Sqrt(2)L
 *
 */
public class TriangularBumper extends Bumper {
    
    /**
     * 
     * @param b : Ball that the bumper is interacting with 
     * @effect : ball position remains unchanged.  Angle is changed to the reflection angle.  Velocity remains the same.  
     */
    public void getgetEffect(Ball b) {
        //TODO
    }
    
    /**
     * 
     * @param b : ball object to test if in bounds 
     * @return : true if the ball is in the space that is occupied by the bumper 
     * 
     */
    public boolean inBounds(Ball b) {
        return false;
        //TODO
    }

}
