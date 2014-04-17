import java.util.ArrayList;

import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

/**
 * 
 * @author Lauren 
 * 
 * A class representing a Bumper 
 * 
 * Rep Invariant: position must not change
 *
 */
public class Bumper implements Stationary {
 
    
    /**
     * ensure the rep invariant of Bumper is preserved
     */
    public boolean checkRep() {
        return true;
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

	@Override
	public ArrayList<Object> getPhysicsObjects() {
		return null;
	}

}
