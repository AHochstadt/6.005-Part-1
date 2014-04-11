
public interface Stationary {
    
    /**
     * returns the bounds on the location (all parts of the object are contained within the region)
     */
    public void getLocationBounds();
    
    /**
     * returns the new speed and angle for the ball 
     */
    public void getEffect();

}
