package warmup;

public class Board {
    private final int height;
    private final int width;
    private final Ball[] components; // the balls that are active on this Board
    
    Board(int h, int w, Ball[] components) {
        this.height = h;
        this.width = w;
        this.components = components;
    }
    /**
     * 
     * @param timestep timestep in seconds
     * @return
     */
    public String update(double timestep) {
    	for (Ball ball: components){
    	    
    		double oldX = ball.getX();
    		double oldY = ball.getY();
    		double oldAngle = ball.getAngle();
    		double deltaX = timestep*ball.getVelocity()*Math.cos(Math.toRadians(ball.getAngle()));
    		double deltaY = -1*timestep*ball.getVelocity()*Math.sin(Math.toRadians(ball.getAngle())); //*-1 because we define +y to be in the downward direction
    		double newX = oldX + deltaX;
    		double newY = oldY + deltaY; 
    		double newAngle = oldAngle; //initializes new angle assuming no walls have been hit and therefore angle has not changed
    		
    		if ((newX<0.0 || newX>this.width) || (newY<0.0 || newY>this.height)){ //will fix newX, newY and/or newAngle if walls have been hit
    			
    			//this while loop determines the first wall hit, then changes the x, y, and angle accordingly
    			//after that it determines the next wall hit and so on until we reach a valid position in the board
    			
    			String leftOrRightWall = "unknown";
    			String upperOrLowerWall = "unknown";
    			String wallHitFirst = "unknown";
    			
    			if (newX<0.0){ //we will determine whether we are out of bounds to the left or to the right
    				leftOrRightWall = "left";
    			} else if (newX>this.width){
    				leftOrRightWall = "right";
    			} else { 
    				leftOrRightWall = "neither";
    			}
    			
    			if (newY<0.0){ //we will determine whether we are out of bounds up or down
    				upperOrLowerWall = "upper"; // negative y-coordinate corresponds to being ABOVE our top wall
    			} else if (newY>this.height){
    				upperOrLowerWall = "lower";
    			} else {
    				upperOrLowerWall = "neither";
    			}
    			
    			wallHitFirst = determineFirstHitWall(upperOrLowerWall, leftOrRightWall, newX, newY, newAngle, ball.getVelocity());
    			
    			if (!wallHitFirst.equals("none")){
    				System.out.println(wallHitFirst);
    				if(wallHitFirst.equals("upper")){
    					newY = 0.0 - newY;
    					newAngle = 360.0 - newAngle;
    				}
    				if (wallHitFirst.equals("lower")){
    					newY = (2.0*this.height) - newY;
    					newAngle = 360.0 - newAngle;
    				}
    				if (wallHitFirst.equals("left")){
    					newX = 0.0 - newX;
    					newAngle = 180.0 - newAngle;
    				}
    				if (wallHitFirst.equals("right")){
    					newX = (2.0*this.width) - newX;    					
    					newAngle = 180.0 - newAngle;
    				} 
    			}
    				
    		}
    		ball.setAngle(newAngle);
    		ball.setX(newX);
    		ball.setY(newY);
    	}
    	
        return this.getBoardRep();
    }
    
    // return a string stating which wall (left, right, upper, lower) the ball hits first
    private String determineFirstHitWall(String upperOrLowerWall, String leftOrRightWall, double newX, double newY, double newAngle, double velocity) {
    	double velX = velocity*Math.cos(Math.toRadians(newAngle));
    	double velY = -1*velocity*Math.sin(Math.toRadians(newAngle));
    	
    	if (upperOrLowerWall.equals("neither") && leftOrRightWall.equals("neither")){ //we are not out of bounds
			return "none";
		}
    	if (upperOrLowerWall.equals("neither")){ // we are only out of bounds in the x direction
    		return leftOrRightWall;
    	}
    	if (leftOrRightWall.equals("neither")){ //we are only out of bounds in the y direction
    		return upperOrLowerWall;
    	} 
    	
    	if (leftOrRightWall.equals("left") && upperOrLowerWall.equals("upper")){//we are too far both left and up
    		if ((newX/velX)>(newY/velY)){ //left wall hit first
    			return "left";
    		} else {
    			return "upper";
    		}
    	}
    	
    	if (leftOrRightWall.equals("left") && upperOrLowerWall.equals("lower")){//we are too far both left and down
    		if ((newX/velX)>((newY-this.height)/velY)){//left wall hit first
    			return "left";
    		} else {
    			return "lower";
    		}
    	}
    	
    	if (leftOrRightWall.equals("right") && upperOrLowerWall.equals("upper")){//we are too far both right and up
    		if (((newX-this.width)/velX)>(newY/velY)){ //right wall hit first
    			return "right";
    		} else {
    			return "upper";
    		}
    	}
    	
    	if (leftOrRightWall.equals("right") && upperOrLowerWall.equals("lower")){//we are too far both left and down
    		if (((newX-this.width)/velX)>((newY-this.height)/velY)){//right wall hit first
    			return "right";
    		} else {
    			return "lower";
    		}
    	}
		return "this string should never be returned";
	}
    
	/**
     * 
     * @return String representation of the board's current state
     */
    public String getBoardRep() {
        String boardRep = ""; 
        
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                for (Ball b: components) {
                    int x = (int) Math.round(b.getX());
                    int y = (int) Math.round(b.getY());
                    // print a ball at the current position
                    if (x == i && y == j) {
                        boardRep = boardRep + "*";
                    }
                    // print a wall piece
                    else if (j == 0 || j == this.height - 1 || i == 0 || i == this.width - 1) {
                        boardRep = boardRep + ".";
                    }
                    // print empty space
                    else {
                        boardRep = boardRep + " ";
                    }
                }
            }
            boardRep = boardRep + "\n";
        }
        return boardRep;
    }

}
