
/**
 * 
 * @author Lauren 
 *
<<<<<<< HEAD
 *A square shape with an edge length 1L.  Constructor takes two opposite corners as inputs 
=======
 * A square shape with an edge length 1L.  
>>>>>>> 090516a470e2839e51b7936943dd191217377075
 *
 * Rep Invariant: edges of length 1L
 *                position is fixed
 */
public class SquareBumper extends Bumper {
    int corner1x;
    int corner1y;
    int corner2x;
    int corner2y;
    
    SquareBumper(int x1, int y1, int x2, int y2) {
        this.corner1x = x1;
        this.corner1y = y1;
        this.corner2x = x2;
        this.corner2y = y2;
     
    }
    
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
