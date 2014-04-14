/**
 * 
 * @author Lauren 
 * 
 * An representing flipper, an object with a stationary end and a moving end 
 * 
 * Rep Invariant: the flipper must never move outside of the bounding box 
 *
 */
public interface Flipper {

    /**
     * moves the moving end of the flipper
     * flipper will move at a constant rotational velocity to be 90 degrees away from it's starting position.  
     * flipper will never move outside of the bounding box 
     */
    public void move();
    
    /**
     * 
     * @return fixed x value 
     */
    public float getFixedX() ;
    /**
     * 
     * @return moving y value 
     */
    public float getFixedY() ;
    
    /**
     * 
     * @return moving x value 
     */
    public float getMovingX() ;
    
    /**
     * 
     * @return moving x value 
     */
    public float getMovingY() ;
    
    /**
     * modifies the ball based on the interaction 
     * @param b : the ball interacting with the flipper
     * @effect : doesn't change the position of the ball, changes the angle, changes the velocity to 0.95 of the original velocity
     */
    public void getEffect(Ball b) ;

}
