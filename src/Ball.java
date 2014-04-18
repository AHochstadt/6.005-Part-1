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
    /**
    * 
    * @param newV the velocity to change the current velocity to
    */
   public void setPhysicsPackageVelocity(Vect newV) {
       double newY = 0.0-newV.y();
	   this.velocity = new Vect(newV.x(), newY);
       
   }
    
    public Circle getCircle() {
        return new Circle(ballVector.x(), ballVector.y(), 0.25);
    }
    
    public Circle getPhysicsPackageCircle() {
        return new Circle(ballVector.x(), 20.0-ballVector.y(), 0.25);
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
	
	/**
	 * Converts current ball velocity vector to cartesian coordinates for use in Physics Package
	 * @return cartesian vector
	 */
	public Vect getPhysicsPackageVelocity() {
		double x = velocity.x();
		double y = 0.0-velocity.y();
		return new Vect(x, y);
	}

	public Vect getBallVector() {
		return ballVector;
	}
	
	/**
	 * Converts current ball position vector to cartesian coordinates for use in Physics Package
	 * @return cartesian vector
	 */
	public Vect getPhysicsPackageBallVector() {
		double x = ballVector.x();
		double y = 20.0-ballVector.y();
		return new Vect(x, y);
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

	public void setPhysicsPackageBallVector(Vect vect) {
		double y = 20.0-vect.y();
		this.ballVector = new Vect(vect.x(), y);
	}


}
