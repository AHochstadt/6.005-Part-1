import java.util.ArrayList;
import physics.*;
/**
 * 
 * @author Lauren 
 *
 *A square shape with an edge length 1L.  Constructor takes two opposite corners as inputs 
 * A square shape with an edge length 1L.  
 *
 * Rep Invariant: edges of length 1L
 *                position is fixed
 */
public class SquareBumper extends Bumper {
	
    LineSegment side1;
    LineSegment side2;
    LineSegment side3;
    LineSegment side4;
    ArrayList<LineSegment> sides = new ArrayList<LineSegment>();
    Circle corner1;
    Circle corner2;
    Circle corner3;
    Circle corner4;
    ArrayList<Circle> corners = new ArrayList<Circle>();

    String name;
    double x;
    double y;
    /**
     * Constructor for Square Bumper
     * @author ahochstadt
     * @param x x-coordinate of bumper (should be natural number)
     * @param y y-coordinate of bumper (should be natural number)
     * @param name name of bumper
     */
    SquareBumper(double x, double y, String name){
    	this.name = name;
    	this.corner1 = new Circle(x, y, 0.0); //creates the line segments and corners starting at (x,y) and going around in a clockwise fashion
    	this.side1 = new LineSegment(x, y, x+1, y);
    	this.corner2 = new Circle(x+1, y, 0.0);
    	this.side2 = new LineSegment(x+1, y, x+1, y+1);
    	this.corner3 = new Circle(x+1, y+1, 0.0);
    	this.side3 = new LineSegment(x+1, y+1, x, y+1);
    	this.corner4 = new Circle(x, y+1, 0.0);
    	this.side4 = new LineSegment(x, y, x, y+1);
    	this.sides.clear();
    	this.sides.add(this.side1); this.sides.add(this.side2); this.sides.add(this.side3); this.sides.add(this.side4); //populates this.sides
    	this.corners.clear();
    	this.corners.add(this.corner1); this.corners.add(this.corner2); this.corners.add(this.corner3); this.corners.add(this.corner4); //populates this.corners
    	
    }
     
    
    
    /**
     * 
     * @param b: ball object that comes into contact with the bumper
     * @effect: ball position remains unchanged.  Angle is changed to the reflection angle.  Velocity remains the same.  
     */
    public void getEffect(Ball b) {
        //if ball is going to hit side 1
        Vect newV1 = Geometry.reflectWall(this.side1, b.getVelocity());
        b.setVelocity(newV1);
        
        //if ball is going to hit side 2
        Vect newV2 = Geometry.reflectWall(this.side2, b.getVelocity());
        b.setVelocity(newV2);
        
        //if ball is going to hit side3
        Vect newV3 = Geometry.reflectWall(this.side3, b.getVelocity());
        b.setVelocity(newV3);
        
        //if ball is going to hit side4
        Vect newV4 = Geometry.reflectWall(this.side4, b.getVelocity());
        b.setVelocity(newV4);
        
       
    }
    
    /**
     * 
     * @param b: ball object to test if in bounds 
     * @return: true if the ball is in the space that is occupied by the bumper 
     * 
     */
    @Override
    public boolean inBounds(Ball b) {
        return false;
        //TODO
    }
    
    /**
     * ensure the rep invariant of Square Bumper is preserved
     */
    private void checkRep() {
        
    }

}
