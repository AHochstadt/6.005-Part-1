import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
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
 *                  wallConnections.get(wallA) = wallB iff wallConnections.get(wallB) = wallA
 *                  
 * clients: a mapping of Board names to Client instances that are currently on the server
 * 
 * Rep Invariant: queue, wallConnections, and clients are non-null
 * 
 * TODO: Thread-safety argument
 *
 */
@SuppressWarnings("unused") // to be removed later
public class PingballServer {
    
    private final ServerSocket serverSocket;
    
    private final BlockingQueue<Ball> queue;
    
    private final Map<Wall, Wall> wallConnections;
    
    private final Map<String, PingballClient> clients;
    
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
        this.wallConnections = new ConcurrentHashMap<Wall, Wall>();
        this.clients = new ConcurrentHashMap<String, PingballClient>();
        
        checkRep();
    }
    
    /**
     * Listen for messages from console
     */
    public void background() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                String line;
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                    while ((line = in.readLine()) != null) {
                        // do stuff
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
    
    /**
     * Run the server, listening for client connections and handling them.
     * 
     * @throws IOException if the main server socket is broken
     */
    public void serve() throws IOException {
        
        // server listening for client connections
        while (true) {
            //block until a client connects
            final Socket socket = serverSocket.accept();
            //PingballClient client = new PingballClient(socket, this.queue);
            
         // create a new thread for each client
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    // handle the client
                    try {
                        handleConnection(socket);
                    }
                    catch (IOException e) {
                        e.printStackTrace(); // but don't terminate serve()
                    }
                    finally {
                        try {
                            socket.close();
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
                       
            // add the client's Board and the client to the mapping of active clients
            //this.clients.put(client.getBoard().getBoardName(), client);
        }
        
    }
    
    /**
     * Handle a single client connection. Returns when client disconnects. 
     * 
     * @param socket socket where the client is connected
     * @throws IOException if connection has an error or terminates unexpectedly
     */
    private void handleConnection(Socket socket) throws IOException {
        // this is where we call sendBall, connectWalls, etc.
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        
        try {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                //String output = handleRequest(line);
            }
        }
        finally {
            out.close();
            in.close();
        }
        
    }
    
    /**
     * Handler for client input, performing requested operations and returning an output message.
     * 
     * @param input message from client
     * @return message to client
     */
    private String handleRequest(String input) {
        return "";
    }
    

    /**
     * Given a command to join two walls, handle it
     * 
     * @param command Usage: "h NAME_left NAME_right" or "v NAME_top NAME_bottom"
     */
    public void joinCommand(String command) {
        String[] lineList = command.split(" ");
        
        // must be "h" or "v"
        String orientation = lineList[0];
        String boardName1 = lineList[1].split("_")[0];
        String wallName1 = lineList[1].split("_")[1];
        String boardName2 = lineList[2].split("_")[0];
        String wallName2 = lineList[2].split("_")[1];

        if (!boardName1.matches("[A-Za-z_][A-Za-z_0-9]*") || !boardName2.matches("[A-Za-z_][A-Za-z_0-9]*") || 
                !(orientation.equals("h") && wallName1.equals("left") && wallName2.equals("right")) ||
                !(orientation.equals("v") && wallName1.equals("top") && wallName2.equals("bottom"))) {
            throw new IllegalArgumentException("Usage: h NAME_left NAME_right or v NAME_top NAME_bottom");
        }
        
        connectWalls(boardName1, wallName1, boardName2, wallName2);
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
     * @param boardName1 the first Board whose Wall we are joining
     * @param wall1 boardName1's Board to be joined
     * @param boardName2 the first Board whose Wall we are joining
     * @param wall2 boardName1's Board to be joined
     */
    public void connectWalls(String boardName1, String wallName1, String boardName2, String wallName2 ) {
        //(Wall wall1, Wall wall2) 
        // need to update wallConnections
        // delete the wall connected to wall1 and wall2 if necessary
        // send messages to the owners of wall1 and wall2 notifying that those walls are now connected
    }
    
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
        
        PingballServer server = new PingballServer(port);
        server.serve();
    }
    
    /**
     * Ensure the rep invariants of queue and wallConnections are maintained at all times
     */
    private void checkRep() {
        assert(this.queue != null);
        assert(this.wallConnections != null);
        assert(this.clients != null);
    }

}
