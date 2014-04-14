/**
 * 
 * @author Lauren
 * 
 * A class representing the Absorber
 * An absorber is a rectangle kL x mL 
 * 
 * Rep Invariant: k and m are positive integers <= 20 and >= 1
 *                position is fixed
 *
 */
public class Absorber implements Stationary {

    @Override
    public boolean inBounds(Ball b) {
        return false;
        // TODO Auto-generated method stub
        
    }

    /**
     * ball will be removed from the board if absorber is not holding a ball (board.remove)
     * absorber will hold the ball
     * 
     * if the absorber is holding a ball, then this ball will shoot out of the absorber when a ball hits the absorber (board.add)
     * 
     * @param b
     */
    @Override
    public void getEffect(Ball b) {
        // TODO Auto-generated method stub
        
    }
    
    /**
     * ensure the rep invariant of Absorber is preserved
     */
    private void checkRep() {
        
    }

}
