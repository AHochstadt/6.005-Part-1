/**
 * 
 * @author Lauren 
 * 
 * A class representing a left flipper
 * 
 * Rep Invariant: flipper remains within the bounding box
 *                stationary end of Left Flipper is fixed
 *
 */
public class LeftFlipper implements Flipper {
    private final float xOrig;
    private final float yOrig;
    private float xMov;
    private float yMov;
    
    LeftFlipper(float x, float y, float xM, float yM) {
        xOrig = x;
        yOrig = y;
        xMov = xM;
        yMov = yM;
    }
    /**
     * moves the moving end of the flipper
     * flipper will move at a constant rotational velocity to be 90 degrees away from its starting position.  
     * flipper will never move outside of the bounding box 
     */
    public void move() {
        //TODO 
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
        //TODO
    }
    
    /**
     * ensure the rep invariant of Left Flipper is preserved.  Inside bounding box, with moving end, never further away than 2L from origin 
     */
    private void checkRep() {
        
    }


}
