import physics.*;
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
    LineSegment side1;
    LineSegment side2;
    LineSegment side3;
    
    TriangularBumper(double orgX, double orgY, double point1x, double point1y, double point2x, double point2y) {
        this.side1 = new LineSegment(orgX, orgY, point1x, point1y);
        this.side2 = new LineSegment(point1x, point1y, point2x, point2y);
        this.side3 = new LineSegment(point2x, point2y, orgX, orgY);
    }
    
    /**
     * 
     * @param b : Ball that the bumper is interacting with 
     * @effect : ball position remains unchanged.  Angle is changed to the reflection angle.  Velocity remains the same.  
     */
    public void getEffect(Ball b) {
        //if ball is going to hit side 1
        Vect newV1 = Geometry.reflectWall(this.side1, b.getVelocity());
        b.setVelocity(newV1);
        
        //if ball is going to hit side 2
        Vect newV2 = Geometry.reflectWall(this.side2, b.getVelocity());
        b.setVelocity(newV2);
        
        //if ball is going to hit side3
        Vect newV3 = Geometry.reflectWall(this.side3, b.getVelocity());
        b.setVelocity(newV3);
    }
    
    /**
     * 
     * @param b : ball object to test if in bounds 
     * @return : true if the ball is in the space that is occupied by the bumper 
     * 
     */
    @Override
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
