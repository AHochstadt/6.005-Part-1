
/**
 * 
 * @author Lauren 
 * 
 * A right-triangle shaped bumper 
 * 
 * Rep Invariant: sides of 1L and hypotenuse of length Sqrt(2)L
 *                position is fixed
 *
 */
public class TriangularBumper extends Bumper {
    double orgY;
    double orgX;
    double point1x;
    double point1y;
    double point2x;
    double point2y;
    
    TriangularBumper(double orgX, double orgY, double point1x, double point1y, double point2x, double point2y) {
        this.orgY = orgY;
        this.orgX = orgX;
        this.point1x = point1x;
        this.point1y = point1y;
        this.point2x = point2x;
        this.point2y = point2y;
    }
    
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
    
    /**
     * ensure the rep invariant of Triangular Bumper is preserved
     */
    private void checkRep() {
        
    }

}
