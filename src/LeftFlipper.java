import physics.*;
/**
 * 
 * @author Lauren 
 * @author ahochstadt
 * A class representing a left flipper
 * 
 * Rep Invariant: flipper remains within the bounding box
 *                stationary end of Left Flipper is fixed
 *
 */
public class LeftFlipper implements Flipper {
	Circle pivot;
	Circle endPoint;
    LineSegment flipper;
    Vect origin;
    double orientation;
    double xPivot;
    double yPivot;
    double xEndpt;
    double yEndpt;
    
    /**
     * Constructor for Left Flipper
     * @author ahochstadt
     * @param x x-coordinate for upperleft corner of 2Lx2L bounding box
     * @param y y-coordinate for upperleft corner of 2Lx2L bounding box
     * @param orientation can be 0|90|180|270. Measure (in degrees) of how much the original flipper bumper is rotated. Original bumper (orientation = 0) lies on the west side of the bounding box.
     * @param name name of the flipper
     */
    LeftFlipper(int x, int y, int orientation, String name) {
        this.flipper = new LineSegment(x,y,x+2,y);
        this.origin = new Vect(x,y);
        // TODO write constructor
    }
    /**
     * moves the moving end of the flipper
     * flipper will move at a constant rotational velocity to be 90 degrees away from its starting position.  
     * flipper will never move outside of the bounding box 
     */
    public void move() {
        Geometry.rotateAround(this.flipper,this.origin, new Angle(-90));
        //update xMov and yMov
    }
    
    
    /**
     * 
     * @return fixed x value 
     */
    public double getFixedX() {
        return xPivot;
    }

    /**
     * 
     * @return moving y value 
     */
    public double getFixedY() {
        return yPivot;
        
    }
    
    /**
     * 
     * @return moving x value 
     */
    public double getMovingX() {
        return xEndpt;
        
    }
    
    /**
     * 
     * @return moving x value 
     */
    public double getMovingY() {
        return yEndpt;
    }
    
    @Override
    public boolean inBounds(Ball b) {
        // TODO Auto-generated method stub
        return false;
    }
    
    /**
     * 
     * @param b : the ball interacting with the flipper
     * @effect doesn't change the position of the ball, changes the angle, changes the velocity to 0.95 of the original velocity
     */
    public void getEffect(Ball b) {
        Vect newV = Geometry.reflectRotatingWall(this.flipper,this.origin, 1.0,b.getCircle(),b.getVelocity(), 0.95);
        b.setVelocity(newV);
    }
    
    /**
     * ensure the rep invariant of Left Flipper is preserved.  Inside bounding box, with moving end, never further away than 2L from origin 
     */
    private void checkRep() {
        
    }


}
