import com.sun.java.util.jar.pack.Package.File;


/**
* A class representing a users Pingball board
*
* rep invariant: flippers, stationaryItems, and balls all must not be null
**/
public class Board {
    private final Stationary[] nonMovingParts;
    private final Flipper[] flippers;
    private Ball[] balls; //not final becuase balls can be added 
    
    /**
     * creates a new instance of board from the input file
     * @param boardFile a Pingball Board File specifying the board
     */
    
    Board(File boardFile) {
        //TODO

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

}
