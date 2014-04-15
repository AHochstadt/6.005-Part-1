import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import warmup.Ball;



/**
* A class representing a users Pingball board
*
* Rep invariant: flippers, stationaryItems, and balls all must not be null
**/ 
public class Board {
    // TODO: initialize all this to non-null
    private final Stationary[] nonMovingParts = null;
    private final Flipper[] flippers = null;
    private ArrayList<Ball> balls = null; //not final becuase balls can be added 
    private String leftWall = null; //either states the name of the ball or the String STATIONARY
    private String rightWall = null;
    private String topWall = null;
    private String bottomWall = null;
    
    /**
     * @author ahochstadt
     * creates a new instance of board from the input file
     * @param filePath the address of the Pingball Board File specifying the board
     * @throws IOException 
     */
    public Board(String filePath) throws IOException {
    	try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = null;
            while ((line = reader.readLine()) != null) {
            	if(line.contains("board")){
            		//parse board
            	}
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    /**
     * 
     * @param timestep timestep in seconds
     * @return String representing the boards current state: will use the following procedure:
     * flippers update
     * balls update
     * collisions are checked for balls (ball loop twice)
     * new actions set 
     */
    public String update(double timestep) {
        //I was not clear if flippers are moving in this version of the game, if so they would move here.  
        
        for (Ball b: balls) {
            for (Stationary s: nonMovingParts) {
                if (s.inBounds(b)) {
                    s.getEffect(b);
                }
            }
        }
        
        for (Ball ball1: balls) {
            for (Ball ball2: balls) {
                if (ball1.getX() == ball2.getX() && ball1.getY() == ball2.getY()) {
                    // calculate collision using reflectBalls
                }
            }
        }
        
        return getBoardRep();
    }
    
    
    /**
     * adds new ball to the board 
     * @param b
     */
    public void addBall(Ball b) {
        balls.add(b);
    }
    
    /**
     * removes ball from this board
     * sends ball in a message to the server along with, the name of the board that the ball has come from 
     * @param b
     */
    public String removeBall(Ball b) {
        balls.remove(b);
        //returns a String board message including information about the ball and the board that it came from  
        return "";
    }
    
    
    /**
     * 
     * @return String representation of the board's current state
     */
    public String getBoardRep() {
        String boardRep = ""; 
        
        for (int j = 0; j < 20; j++) {
            for (int i = 0; i < 20; i++) {
                for (Ball b: balls) {
                    int x = (int) Math.round(b.getX());
                    int y = (int) Math.round(b.getY());
                    // print a ball at the current position
                    if (x == i && y == j) {
                        boardRep = boardRep + "*";
                    }
                    // print a wall piece
                    else if (j == 0 || j == 20 - 1 || i == 0 || i == 20 - 1) {
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
    
    /**
     * ensure the rep invariant of Board is preserved
     */
    private void checkRep() {
        
    }

}
