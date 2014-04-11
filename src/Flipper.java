/**
* A class representing a pingball flipper
* x: the current x-coordinate of the flippers origin
* y: the current y-coordinate of the flippers origin
**/
public class Flipper {
    private final float xOrig;
    private final float yOrig;
    private float xMov;
    private float yMov;
    
    Flipper(float x, float y, float xM, float yM) {
        xOrig = x;
        yOrig = y;
        xMov = xM;
        yMov = yM;
    }
    /**
     * moves the moving end of the flipper
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
     * erturns the effect to the ball after interacting with the flipper 
     */
    public void getEffect(Ball b) {
        //TODO
    }
}
