
/**
 * 
 * @author Lauren 
 *
 * A square shape with an edge length 1L.  
 *
 * Rep Invariant: edges of length 1L
 *                position is fixed
 */
public class SquareBumper extends Bumper {
    
    /**
     * 
     * @param b: ball object that comes into contact with the bumper
     * @effect: ball position remains unchanged.  Angle is changed to the reflection angle.  Velocity remains the same.  
     */
    public void getEffect(Ball b) {
        //TODO
    }
    
    /**
     * 
     * @param b: ball object to test if in bounds 
     * @return: true if the ball is in the space that is occupied by the bumper 
     * 
     */
    public boolean inBounds(Ball b) {
        return false;
        //TODO
    }
    
    /**
     * ensure the rep invariant of Square Bumper is preserved
     */
    private void checkRep() {
        
    }

}
