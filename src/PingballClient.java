import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * 
 * @author DylanJoss
 *
 * A class representing a Pingball client
 * 
 * board: the Board instance this client is using to play
 *
 */
public class PingballClient {

    private final Board board = null; // will re-assign later
    
    /**
     * Start up a new client playing Pingball
     * 
     * @param board the Board this client will use in playing Pingball
     */
    public PingballClient(Board board) {
        
    }
    
    /**
     * Given a message from the server that a new Ball is to enter this.board, add it to the board
     */
    public void addBall() {
        
    }
    
    /**
     * If a ball will leave the current game Board, send a message to the server indicating as such
     */
    public void sendBall() {
        
    }
    
    /**
     * Update the walls of this.board to indicate new connections or that old connections are no longer in place
     */
    public void updateWalls() {
        
    }
    
    /**
     * Start up this client playing Pingball
     * 
     * Usage: PingballClient [--host HOST] [--port PORT] FILE
     * 
     * HOST is an optional hostname or IP address of the server to connect to. If no HOST is provided, 
     * then the client starts in single-machine play mode.
     * 
     * PORT is an optional integer in the range 0 to 65535 inclusive, specifying the port where the server 
     * is listening for incoming connections. The default port is 10987.
     * 
     * FILE is a required argument specifying a file pathname of the Pingball board that this client should run.
     * 
     * @param args
     */
    public static void main(String[] args) {
        int port = 10987;
        File file = null;
        String host = null;
        
        Queue<String> arguments = new LinkedList<String>(Arrays.asList(args));
        try {
            while ( ! arguments.isEmpty()) {
                String flag = arguments.remove();
                try {
                    if (flag.equals("--host")) {
                        host = arguments.remove();
                    } else if (flag.equals("--port")) {
                        port = Integer.parseInt(arguments.remove());
                        if (port < 0 || port > 65535) {
                            throw new IllegalArgumentException("port " + port + " out of range");
                        }
                    } else if (flag.equals("--file")) {
                        file = new File(arguments.remove());
                        
                        // TODO: Load the board from the file here, using the Parser 
                        
                        if ( ! file.isFile()) {
                            throw new IllegalArgumentException("file not found: \"" + file + "\"");
                        }
                    } else {
                        throw new IllegalArgumentException("unknown option: \"" + flag + "\"");
                    }
                } catch (NoSuchElementException nsee) {
                    throw new IllegalArgumentException("missing argument for " + flag);
                } catch (NumberFormatException nfe) {
                    throw new IllegalArgumentException("unable to parse number for " + flag);
                }
            }
        } catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
            System.err.println("PingballClient [--host HOST] [--port PORT] FILE");
            return;
        }

        try {
            if (host == null) {
                // TODO: start up this client in single-machine play
            }
            else {
                // TODO: connect to the server and start up this client in client-server play
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
