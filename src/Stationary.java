import java.util.ArrayList;



/**
 * 
 * @author ahochstadt 
 * 
 * An interface for stationary items.
 * 
 */
public interface Stationary extends Gadget{


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

    String getName();





}
