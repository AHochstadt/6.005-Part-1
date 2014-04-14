/**
 * 
 * @author Lauren 
 * A class representing the Absorber
 * An absorber is a rectangle kL x mL 
 * 
 * Rep Invariant: k and m are positive integers <= 20 and >= 1
 *
 */
public class Absorber implements Stationary {
    int corner1x;
    int corner2x;
    int corner1y;
    int corner2y;
    
    Absorber(int x1, int y1, int x2, int y2) {
        corner1x = x1;
        corner2x = x2;
        corner1y = y1;
        corner2y = y2;
    }
    

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
