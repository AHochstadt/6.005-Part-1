import java.util.ArrayList;

import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;


public class Wall implements Stationary{
	private boolean solid;
	private String wallName;
	private String location;
	private LineSegment wallSegment;
	private Circle endpt1;
	private Circle endpt2;
	private ArrayList<Object> physicsObjects = new ArrayList<Object>();
	private Board parentBoard;
	
	/**
	 * Constructor of Wall 
	 * @param location = "left"|"up"|"right"|"down"
	 */
	Wall(Board parentBoard, String location){//initializes a solid wall not connected to another board
		this.parentBoard = parentBoard;
		this.setLocation(location);
		this.setSolid(true);
		this.setWallName("");
		
		if (location.equals("up")){
			this.setWallSegment(new LineSegment(0.0, 0.0, 20.0, 0.0));
			this.setEndpt1(new Circle(0.0, 0.0, 0.0));
			this.setEndpt2(new Circle(20.0, 0.0, 0.0));			
		} else if (location.equals("right")){
			this.setWallSegment(new LineSegment(20.0, 0.0, 20.0, 20.0));
			this.setEndpt1(new Circle(20.0, 0.0, 0.0));
			this.setEndpt2(new Circle(20.0, 20.0, 0.0));			
		} else if (location.equals("down")){
			this.setWallSegment(new LineSegment(0.0, 20.0, 20.0, 20.0));
			this.setEndpt1(new Circle(0.0, 20.0, 0.0));
			this.setEndpt2(new Circle(20.0, 20.0, 0.0));			
		} else { //location should be "left"
			this.setWallSegment(new LineSegment(0.0, 0.0, 0.0, 20.0));
			this.setEndpt1(new Circle(0.0, 0.0, 0.0));
			this.setEndpt2(new Circle(0.0, 20.0, 0.0));			
		}
		
		this.physicsObjects.add(this.endpt1); this.physicsObjects.add(this.endpt2); this.physicsObjects.add(this.wallSegment); //populates physicsObjects
	}

	@Override
	public ArrayList<Object> getPhysicsObjects() {
		return this.physicsObjects;
	}
	
	/**@author ahochstadt
     * updates ball based on the balls recent interaction 
     */
	@Override
	public void getEffect(Ball b, Object objectHit) {
		if (this.isSolid()){
			if (objectHit instanceof Circle){
				Circle circleHit = (Circle) objectHit;
				Vect newV = Geometry.reflectCircle(circleHit.getCenter(), b.getVector(), b.getVelocity()); //don't need reflection coef because it's 1
				b.setVelocity(newV);
			}
	    	if (objectHit instanceof LineSegment){
	    		LineSegment segmentHit = (LineSegment) objectHit;
	    		Vect newV = Geometry.reflectWall(segmentHit, b.getVelocity()); //don't need reflection coef because it's 1
	            b.setVelocity(newV);
	    	}
		} else { //send the ball away!
			//board.sendBall(b);
		}
		
	}

	public LineSegment getWallSegment() {
		return wallSegment;
	}

	public void setWallSegment(LineSegment wallSegment) {
		this.wallSegment = wallSegment;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Circle getEndpt1() {
		return endpt1;
	}

	public void setEndpt1(Circle endpt1) {
		this.endpt1 = endpt1;
	}

	public Circle getEndpt2() {
		return endpt2;
	}

	public void setEndpt2(Circle endpt2) {
		this.endpt2 = endpt2;
	}

	@Override
	public void trigger() {//does nothing by definition of wall
	}

	@Override
	public void action() {//does nothing by definition of wall		
	}

	public void wallify() {
		this.setSolid(true);
		this.setWallName("");
	}

	public boolean isSolid() {
		return solid;
	}

	public void setSolid(boolean solid) {
		this.solid = solid;
	}

	public String getWallName() {
		return wallName;
	}

	public void setWallName(String wallName) {
		this.wallName = wallName;
	}

	public void connectWall(String connectedBoardName) {
		this.setSolid(false);
		this.setWallName(connectedBoardName);
		
	}

	public Board getParentBoard() {
		return this.parentBoard;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParentBoard(Board parent) {
		// TODO Auto-generated method stub
		
	}


}
