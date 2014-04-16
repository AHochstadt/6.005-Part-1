import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * @author DylanJoss
 * 
 * A class representing the server that runs the Pingball games
 * 
 * serverSocket: the socket with which the server uses to listen to client requests to connect
 * 
 * queue: the message queue that holds Balls exiting one Board and entering another
 * 
 * wallConnections: a mapping of walls to the other wall to which they are connected
 * 
 * Rep Invariant: queue and wallConnections are non-null
 *                wallConnections.get(wallA) = wallB iff wallConnections.get(wallB) = wallA
 * 
 * TODO: Thread-safety argument
 *
 */
@SuppressWarnings("unused") // to be removed later
public class PingballServer {
    
    private final ServerSocket serverSocket;
    
    private final BlockingQueue<Ball> queue;
    
    //private final Map<Wall, Wall> wallConnections;
    
    /**
     * Make a Pingball Server that listens for connections on port.
     * 
     * @param port port number, requires 0 <= port <= 65535
     * 
     * @throws IOException if the main server socket is broken
     */
    public PingballServer(int port) throws IOException {
        
        this.serverSocket = new ServerSocket(port);
        
        this.queue = new LinkedBlockingQueue<Ball>();
        
        
        
    }
    
    /**
     * Run the server, listening for client connections and handling them.
     * 
     * @throws IOException if the main server socket is broken
     */
    public void serve() throws IOException {
        
        while (true) {
            //block until a client connects
            final Socket socket = serverSocket.accept();
            
            //create a new thread for each client
        }
        
    }
    
    /**
     * Handle a single client connection. Returns when client disconnects. 
     * 
     * @param socket socket where the client is connected
     * @throws IOException if connection has an error or terminates unexpectedly
     */
    private void handleConnection(Socket socket) throws IOException {
        
    }
    
    /**
     * Given a Ball that exited some client Board, determine where that Ball will go
     * and send it to the appropriate Board
     * 
     */
    public void sendBall() {
        // take ball off queue, determine where it will go, send it to the appropriate board
        try {
            Ball ballToSend = this.queue.take();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    /**
     * Given a client request to join two walls of a Board or Boards together, join them together
     * 
     * @param wall1 the first Wall to be connected
     * @param wall2 the second Wall to be connected
     */
    public void connectWalls() {
        //(Wall wall1, Wall wall2) 
    }
        // need to update wallConnections
        // send messages to the owners of wall1 and wall2 notifying that those walls are now connected
    //
    
    /**
     * Disconnect two walls
     * 
     * @param wall1 the first Wall to be connected
     * @param wall2 the second Wall to be connected
     */
    public void disconnectWalls() {
        // Wall wall1, Wall wall2
        // need to update wallConnections
        // send messages to the owners of wall1 and wall2 notifying that those walls are now connected
    }
    
    /**
     * Start a PingballServer using the given argument
     * 
     * Usage: PingballServer [--port PORT]
     * 
     * PORT is an optional integer in the range 0 to 65535 inclusive, specifying the port 
     * where the server should listen for incoming connections. The default port is 10987.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        int port = 10987;
        
        Queue<String> arguments = new LinkedList<String>(Arrays.asList(args));
        try {
            while ( ! arguments.isEmpty()) {
                String flag = arguments.remove();            
                try {
                    if (flag.equals("--port")) {
                        port = Integer.parseInt(arguments.remove());
                        if (port < 0 || port > 65535) {
                            throw new IllegalArgumentException("port " + port + " out of range");
                        }
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
            runPingballServer(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
                    
    }
    
    /**
     * Start a Pingball server running on the specified port.
     * 
     * Usage: PORT is an optional integer in the range 0 to 65535 inclusive, specifying the port where the server 
     * should listen for incoming connections. The default port is 10987.
     * 
     * @param port The network port on which the server should listen.
     * 
     * @throws IOException
     */
    public static void runPingballServer(int port) throws IOException {
        
    }
    
    /**
     * Ensure the rep invariants of queue and wallConnections are maintained at all times
     */
    private void checkRep() {
        assert(this.queue != null);
    }

}
