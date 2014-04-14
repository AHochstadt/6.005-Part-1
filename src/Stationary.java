/**
 * 
 * @author Lauren 
 * 
 * An interface for stationary items.
 * 
 * Rep Invarient: position must not change 
 *
 */
public interface Stationary {
    
    /**
     * returns true if the ball is within the bounds of this iten 
     */
    public boolean inBounds(Ball b);
    
    /**
     * returns the new speed and angle for the ball 
     */
    public void getEffect(Ball b);


}
