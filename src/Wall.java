import java.util.ArrayList;

import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;


public class Wall implements Stationary{
	private String location;
	private LineSegment wallSegment;
	private Circle endpt1;
	private Circle endpt2;
	private ArrayList<Object> physicsObjects = new ArrayList<Object>();
	Wall(String location){
		this.setLocation(location);
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

}
