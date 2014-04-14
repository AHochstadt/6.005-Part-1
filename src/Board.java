import java.io.BufferedReader;
import java.io.FileReader;



/**
* A class representing a users Pingball board
*
* rep invariant: flippers, stationaryItems, and balls all must not be null
**/ 
public class Board {
    private final Stationary[] nonMovingParts;
    private final Flipper[] flippers;
    private Ball[] balls; //not final becuase balls can be added 
    private String leftWall; //either states the name of the ball or the String STATIONARY
    private String rightWall;
    private String topWall;
    private String bottomWall;
    
    /**
     * creates a new instance of board from the input file
     * @param filePath the address of the Pingball Board File specifying the board
     */
    
    Board(String filePath) {
    	BufferedReader reader = new BufferedReader(new FileReader(filePath));
    	//String line = null;
    	//while ((line = reader.readLine()) != null) {

    }
    /**
     * 
     * @param timestep timestep in seconds
     * @return String represetning the boards current state: will use the following procedure:
     * flippers update
     * balls update
     * collisions are checked for balls (ball loop twice)
     * new actions set 
     */
    public String update(double timestep) {
        return null;
        
    }
    
	/**
     * 
     * @return String representation of the board's current state
     */
    public String getBoardRep() {
        return null;
        //TODO
    }
    
    
    /**
     * adds new ball to the board 
     * @param b
     */
    public void addBall(Ball b) {
        //TODO
    }
    
    /**
     * removes ball from this board
     * sends ball in a message to the server along with, the name of the board that the ball has come from 
     * @param b
     */
    public void removeBall(Ball b) {
        //TODO
    }

}
