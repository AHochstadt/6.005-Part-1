package warmup;

public class Ball {
    private double x; //from left 
    private double y; //from top 
    private double angle; // x axis = 0, due north = 90, in degrees
    private double velocity; //in spaces per second
    
    Ball(double x, double y, double angle, double velocity) {
        this.x = x;
        this.y= y;
        this.angle = angle;
        this.velocity = velocity;

    }

    /**
     * 
     * @return angle in degrees where the x axis = 0 and due north = 90
     */
    public double getAngle() {
        return this.angle;
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
    public double getVelocity() {
        return this.velocity;
    }

}