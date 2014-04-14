/**
 * 
 * @author Lauren 
 * 
 * A class representing a right flipper
 * 
 * Rep Invariant: flipper must never move outside of the bounding box 
 *
 */
public class RightFlipper implements Flipper{
    private final double xOrig;
    private final double yOrig;
    private double xMov;
    private double yMov;
    
    RightFlipper(double x, double y, double xM, double yM) {
        this.xOrig = x;
        this.yOrig = y;
        this.xMov = xM;
        this.yMov = yM;
    }
    /**
     * moves the moving end of the flipper
     * flipper will move at a constant rotational velocity to be 90 degrees away from its starting position.  
     * flipper will never move outside of the bounding box 
     */
    public void move() {
        //TODO 
    }
    
    @Override
    public boolean inBounds(Ball b) {
        // TODO Auto-generated method stub
        return false;
    }
    
    /**
     * 
     * @return fixed x value 
     */
    public double getFixedX() {
        return xOrig;
    }

    /**
     * 
     * @return moving y value 
     */
    public double getFixedY() {
        return yOrig;
        
    }
    
    /**
     * 
     * @return moving x value 
     */
    public double getMovingX() {
        return xMov;
        
    }
    
    /**
     * 
     * @return moving x value 
     */
    public double getMovingY() {
        return yMov;
    }
    
    /**
     * 
     * @param b : the ball interacting with the flipper
     * @effect : doesn't change the position of the ball, changes the angle, changes the velocity to 0.95 of the original velocity
     */
    public void getEffect(Ball b) {
        //TODO
    }
    
    /**
     * ensure the rep invariant of Right Flipper is preserved
     */
    private void checkRep() {
        
    }

}