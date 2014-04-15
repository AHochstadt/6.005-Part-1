import warmup.Ball;

/**
 * 
 * @author Lauren 
 * 
 * An interface for stationary items.
 * 
 */
public interface Stationary {
    
    /**
     * returns true if the ball is within the bounds of this item 
     */
    public boolean inBounds(Ball b);

    /**
     * updates ball based on the balls recent interaction 
     */

    public void getEffect(Ball b);




}
