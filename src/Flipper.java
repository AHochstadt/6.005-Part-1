import java.util.ArrayList;

/**
 * 
 * @author Lauren 
 * 
 * An representing flipper, an object with a stationary end and a moving end 
 * 
 */
public interface Flipper extends Gadget {

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
    public double getFixedX() ;
    /**
     * 
     * @return moving y value 
     */
    public double getFixedY() ;
    
    /**
     * 
     * @return moving x value 
     */
    public double getMovingX() ;
    
    /**
     * 
     * @return moving x value 
     */
    public double getMovingY() ;
    


    /**@author ahochstadt
     * updates ball based on the balls recent interaction 
     */
    public void getEffect(Ball b, Object objectHit);
    
    /**
     * @author ahochstadt
     * triggers the action of whatever gadget is hooked up to the triggering gadget
     */
    public void trigger();
    
    /**
     * @author ahochstadt
     * executes action specified by gadget type. Triggered by some (possibly other) gadget
     */
    public void action();
    
    /**
     * @author ahochstadt
     * returns a list of Circles and Segments that belong to the gadget or wall
     */
    public ArrayList<Object> getPhysicsObjects();

}
