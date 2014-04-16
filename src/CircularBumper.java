import java.lang.Object;


import physics.*;
/**
 * 
 * @author Lauren 
 * 
 * A circular shape with diameter 1L 
 *
 * Rep Invariant: position is fixed
 *
 */
public class CircularBumper extends Bumper{
    
    Vect center;
    Circle circleRep;
    Double x;
    Double y;
    
<<<<<<< HEAD
    CircularBumper(double x, double y) {
        this.x = x;
        this.y = y;
        this.center = new Vect(x,y);
        this.circleRep = new Circle(x,y,0.5);
=======
    /**
     * @author ahochstadt
     * @author Lauren
     * Constructor for Circular Bumper
     * @param x x-coordinate of upper-left corner of bumper square (should be natural number)
     * @param y y-coordinate of upper-left corner of bumper square (should be natural number)
     * @param name name of the bumper
     */
    CircularBumper(int x, int y, String name) {
    	//make sure to keep the +.5 in the lines below or make sure to keep the inputs to Vect and Circle doubles somehow
        this.center = new Vect(x+.5,y+.5); //+.5 because (x, y) specifies the upper left corner of the gadget
        this.circleRep = new Circle(x+.5,y+.5,0.5); //+.5 because (x, y) specifies the upper left corner of the gadget
>>>>>>> 6d71ce573344d0da9b17d0cb5678f2b8533bc582
        
    }
    
    
    
    /**
     * 
     * @param b: Ball that the bumper is interacting with 
     * @effect: ball position remains unchanged.  Angle is changed to the reflection angle.  Velocity remains the same.  
     */
    public void getEffect(Ball b) {
        
        Vect newV = Geometry.reflectCircle(this.center, b.getVector(), b.getVector());
        b.setVelocity(newV);
        
    }
    
    /**
     * 
     * @param b: ball object to test if in bounds 
     * @return: true if the ball is in the space that is occupied by the bumper 
     * 
     */
    @Override
    public boolean inBounds(Ball b) {
        if (b.getX() < (this.x + 0.5) && b.getX() > (this.x +0.5)) {
            if (b.getY() < (this.y +0.5) && b.getY() > (this.y + 0.5)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * ensure the rep invariant of Circular Bumper is preserved
     */
    private void checkRep() {
        
    }

}
