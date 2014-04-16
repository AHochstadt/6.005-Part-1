import warmup.Ball;

/**
 * 
 * @author Lauren
 * @author ahochstadt
 * A class representing the Absorber
 * An absorber is a rectangle kL x mL 
 * 
 * Rep Invariant: k and m are positive integers <= 20 and >= 1
 *                position is fixed
 *
 */
public class Absorber implements Stationary {
    double x;
    double y;
    double width;
    double height;
    String name;
    /**
     * Constructor for Absorber
     * @author ahochstadt
     * @param x x-coordinate for upperleft corner of height x width absorber
     * @param y y-coordinate for upperleft corner of height x width absorber
     * @param width width of the absorber
     * @param height height of the absorber
     * @param name name of the absorber. Must be unique to the board file
     */
    Absorber(int x, int y, int width, int height, String name) {
        this.x = (double) x;
        this.y = (double) y; 
        this.width = (double) width;
        this.height = (double) height;
        this.name = name;
        // TODO write Constructor
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
