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
    private Vect velocity; // ball's current velocity (spaces per second)
    private Circle ballCircle;
	private Vect ballVector;
	private String ballName;
	private String boardName;
	private String wallHit;
    
    public Ball(double x, double y, double xVel, double yVel, String ballName) {
        this.ballCircle = new Circle(x,y,0.25);
        this.setBallVector(new Vect(x,y));
        this.velocity = new Vect(xVel, yVel);
        this.ballName = ballName;

    }
    
    public Vect getVector() {
        return this.ballVector;
    }
    
    /**
     * 
     * @param newV the velocity to change the current velocity to
     */
    public void setVelocity(Vect newV) {
        this.velocity = newV;
        
    }
    
    public Circle getCircle() {
        return this.ballCircle;
    }

    /**
     * ensure the rep invariant of Ball is preserved
     */
    public boolean checkRep() {
        return true;
    }

	public Vect getVelocity() {
		return velocity;
	}

	public Vect getBallVector() {
		return ballVector;
	}

	public void setBallVector(Vect ballVector) {
		this.ballVector = ballVector;
	}

	public String getName() {
		return ballName;
	}


	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getWallHit() {
		return wallHit;
	}

	public void setWallHit(String wallHit) {
		this.wallHit = wallHit;
	}


}
