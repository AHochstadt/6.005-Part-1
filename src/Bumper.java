/**
 * 
 * @author Lauren 
 * 
 * A class representing a Bumper 
 * 
 * Rep Invariant: position must not change
 *
 */
public class Bumper implements Stationary {
    
    /**
     * TODO: Javadoc
     */
    public boolean inBounds(Ball b) {
        return false;
        // TODO Auto-generated method stub
        
    }
    
    /**
     * TODO: Javadoc
     */
    public void getEffect(Ball b) {
        // TODO Auto-generated method stub
        
    }
    
    /**
     * ensure the rep invariant of Bumper is preserved
     */
    private void checkRep() {
        
    }

    @Override
    public boolean inBounds(warmup.Ball b) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void getEffect(warmup.Ball b) {
        // TODO Auto-generated method stub
        
    }

}
