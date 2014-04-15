import physics.*;
/**
 * 
 * @author Lauren 
 *
 *A square shape with an edge length 1L.  Constructor takes two opposite corners as inputs 
 * A square shape with an edge length 1L.  
 *
 * Rep Invariant: edges of length 1L
 *                position is fixed
 */
public class SquareBumper extends Bumper {
    LineSegment side1;
    LineSegment side2;
    LineSegment side3;
    LineSegment side4;
    
    SquareBumper(double x1, double y1, double x2, double y2) {
        side1 = new LineSegment(x1,y1,x1,y2);
        side2 = new LineSegment(x1,y2, x2,y2);
        side3 = new LineSegment(x2,y2,x2,y1);
        side4 = new LineSegment(x2,y1,x1,y1);
     
    }
    
    /**
     * 
     * @param b: ball object that comes into contact with the bumper
     * @effect: ball position remains unchanged.  Angle is changed to the reflection angle.  Velocity remains the same.  
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
        
        //if ball is going to hit side4
        Vect newV4 = Geometry.reflectWall(this.side4, b.getVelocity());
        b.setVelocity(newV4);
        
       
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
     * ensure the rep invariant of Square Bumper is preserved
     */
    private void checkRep() {
        
    }

}
