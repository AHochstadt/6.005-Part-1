
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
     * flipper will move at a constant rotational velocity to be 90 degrees away from it's starting position.  
     * flipper will never move outside of the bounding box 
     */
    public void move() {
        //TODO 
    }
    
    /**
     * 
     * @return fixed x value 
     */
    public float getFixedX() {
        return xOrig;
    }

    /**
     * 
     * @return moving y value 
     */
    public float getFixedY() {
        return yOrig;
        
    }
    
    /**
     * 
     * @return moving x value 
     */
    public float getMovingX() {
        return xMov;
        
    }
    
    /**
     * 
     * @return moving x value 
     */
    public float getMovingY() {
        return yMov;
    }
    
    /**
     * 
     * @param b : the ball interacting with the flipper
     * @effect doesn't change the position of the ball, changes the angle, changes the velocity to 0.95 of the original velocity
     */
    public void getEffect(Ball b) {
        //TODO
    }

}
