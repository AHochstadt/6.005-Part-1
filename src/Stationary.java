import java.util.ArrayList;



/**
 * 
 * @author ahochstadt 
 * 
 * An interface for stationary items.
 * 
 */
public interface Stationary {


    /**@author ahochstadt
     * updates ball based on the balls recent interaction 
     */
    public void getEffect(Ball b, Object objectHit);
    
    public ArrayList<Object> getPhysicsObjects();





}
