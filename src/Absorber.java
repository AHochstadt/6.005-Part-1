import warmup.Ball;

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
    double corner1x;
    double corner2x;
    double corner1y;
    double corner2y;
    
    Absorber(double x1, double y1, double x2, double y2) {
        corner1x = x1;
        corner2x = x2;
        corner1y = y1;
        corner2y = y2;
    }
    
    /**
     * ensure the rep invariant of Absorber is preserved
     */
    private void checkRep() {
        
    }

    /**
     * will return true if the ball is in the bounds of the absorber 
     */
    @Override
    public boolean inBounds(Ball b) {
        // TODO Auto-generated method stub
        return false;
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



}
