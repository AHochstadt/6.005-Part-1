import java.lang.Object;

import physics.*;
/**
 * 
 * @author Lauren 
 * 
* A class representing a pingball
* x: the current x-coordinate of the balls origin
* y: the current y-coordinate of the balls origin
* v: the current speed of the ball
* theta: the angle of the ball's current trajectory (measured w.r.t. + x-axis)
* 
* Ball has a 0.5L diameter
* 
* Rep Invariant: Ball must be in bounds of current board 
**/
public class Ball {
    private double x; // ball's position as measured from left wall (center of ball)
    private double y; // ball's position as measured from top wall (center of ball) 
    private double angle; // angle of ball's current trajectory; positive x axis = 0, due north = 90 (degrees)
    private Vect velocity; // ball's current velocity (spaces per second)
    private String board; //board that the ball is currently on 
    private Circle ballCircle;
    private Vect ballVector;
    
    public Ball(double x, double y, double angle, Vect velocity, String board) {
        this.x = x;
        this.y = y;
        this.ballCircle = new Circle(x,y,0.25);
        this.ballVector = new Vect(x,y);
        this.angle = angle;
        this.velocity = velocity;
        this.board = board;

    }

    /**
     * 
     * @return angle in degrees where the x axis = 0 and due north = 90
     */
    public double getAngle() {
        return this.angle;
    }
    
    public Vect getVector() {
        return this.ballVector;
    }

    /**
     * Sets angle value 
     * @param angle in degrees where the x axis = 0 and due north = 90
     */
    public void setAngle(double angle) {
        this.angle = angle;
    }

    /**
     * 
     * @return double y value of location. Measured with 0 as north (the top of the board)
     */
    public double getY() {
        return this.y;
    }

    /**
     * Set y value of position
     * @param y value measured with 0 as north (the top of the board)
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * 
     * @return x value of position with 0 as the left side of the board
     */
    public double getX() {
        return this.x;
    }

    /**
     * 
     * @param x value of position of the ball with 0 as the left side of the board
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * 
     * @return velocity of the ball in spaces per second 
     */
    public Vect getVelocity() {
        return this.velocity;
    }
    
    /**
     * 
     * @param newV the velocity to change the current velocity to
     */
    public void setVelocity(Vect newV) {
        // TODO Auto-generated method stub
        
    }
    
    public Circle getCircle() {
        return this.ballCircle;
    }

    /**
     * ensure the rep invariant of Ball is preserved
     */
    private void checkRep() {
        
    }


}
