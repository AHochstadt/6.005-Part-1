/**
 * 
 * @author Lauren 
 * 
 * A rectangle kL xmL where k and m are positive integers <= 20 and >= 1
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
    //and 
    @Override
    public void getEffect(Ball b) {
        // TODO Auto-generated method stub
        
    }

}
