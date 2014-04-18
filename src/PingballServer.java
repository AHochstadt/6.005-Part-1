import java.io.BufferedReader;
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
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author DylanJoss
 * 
 * A class representing the server that runs the Pingball games
 * 
 * serverSocket: the socket with which the server uses to listen to client requests to connect
 *  
 * wallMap: a mapping of String representations of walls to each other
 *          wallMap.get(wallA) = wallB iff wallMap.get(wallB) = wallA
 *          String representations take the form (left|right|up|down)boardName        
 *                  
 * socketMap: a mapping of Board names to Socket instances that are currently connected to the server
 * 
 * Rep Invariant: wallMap and socketMap are non-null
 * 
 * Thread-safety: We utilize thread-safe datatypes for the mappings of walls to walls and board names to sockets, namely, ConcurrentHashMaps.
 *                Furthermore, the interaction between each Client socket and the server is handled by a unique Thread on the server, so there
 *                is no possibility of multiple Threads on the server interacting with the same Client. Only one user may input join commands from
 *                console, so there is no thread danger there. 
 *
 */
public class PingballServer {
    
    private final ServerSocket serverSocket;
    
    private final Map<String, String> wallMap;
    
    private final Map<String, Socket> socketMap;
        
    /**
     * Make a Pingball Server that listens for connections on port.
     * 
     * @param port port number, requires 0 <= port <= 65535
     * 
     * @throws IOException if the main server socket is broken
     */
    public PingballServer(int port) throws IOException { 
        this.serverSocket = new ServerSocket(port);        
    	this.wallMap = new ConcurrentHashMap<String, String>();
    	this.socketMap = new ConcurrentHashMap<String, Socket>();
        
        background();
        
        checkRep();
    }
    
    /**
     * Listen for messages from console and process as necessary; messages from the console will only ever be join commands.
     * See joinCommand Javadoc for join command protocol.  
     */
    public void background() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                String line;
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                    while ((line = in.readLine()) != null) {
                        joinCommand(line);
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
            	if (line.startsWith("MYNAMEIS")){
            		String boardName = line.split(" ")[1];
        			this.socketMap.put(boardName, socket);
            	} else {
            		handleRequest(line);
            	} 
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
     * @throws IOException if socket connection is unsuccessful
     */
    private void handleRequest(String input) throws IOException {
    	if (input.startsWith("SENDBALL")){
    		sendBall(input);
    	}
    }
    

    /**
     * Given a command to join two walls, handle it.
     * 
     * @param command Usage: "h NAME_left NAME_right" or "v NAME_top NAME_bottom"
     * @throws IOException if socket connection somewhere is unsuccessful
     */
    public void joinCommand(String command) throws IOException {
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
     * @param input 
     * @throws IOException if input is not valid SENDBALL message or if wall is not connected to another wall
     * 
     */
    public void sendBall(String input) throws IOException {
    	if (input.split(" ").length<8){
    		throw new IOException("input message invalid");
    	}
    	String boardname = input.split(" ")[1];
    	String wallHit = input.split(" ")[2];
    	String ballX = input.split(" ")[3];
    	String ballY = input.split(" ")[4];
    	String ballVelX = input.split(" ")[5];
    	String ballVelY = input.split(" ")[6];
    	String ballname = input.split(" ")[7];
    	
    	if (!this.wallMap.containsKey(wallHit+boardname)){
    		throw new IOException("this wall is not connected to another wall");
    	}
    	
    	String connectedWall = this.wallMap.get(wallHit+boardname);
    	
    	if (connectedWall.startsWith("left")){
    		sendBallMessage(connectedWall.substring(0,4), connectedWall.substring(4), "0.0", ballY, ballVelX, ballVelY, ballname);
		}
		if (connectedWall.startsWith("right")){
    		sendBallMessage(connectedWall.substring(0,5), connectedWall.substring(5), "20.0", ballY, ballVelX, ballVelY, ballname);
		}
		if (connectedWall.startsWith("up")){
    		sendBallMessage(connectedWall.substring(0,2), connectedWall.substring(2), ballX, "0.0", ballVelX, ballVelY, ballname);
		}
		if (connectedWall.startsWith("down")){
    		sendBallMessage(connectedWall.substring(0,4), connectedWall.substring(4), ballX, "20.0", ballVelX, ballVelY, ballname);
		}
    	
    	
    }
    /**
     * Sends a RECBALL message to the appropriate board's client
     * @param wallLoc (left|right|up|down)
     * @param receivingBoard the name of the board receiving the board
     * @param ballX 
     * @param ballY
     * @param ballVelX
     * @param ballVelY
     * @param ballname
     * @throws IOException if socket connection is unsuccessful
     */
    private void sendBallMessage(String wallLoc, String receivingBoard, String ballX, String ballY, String ballVelX, String ballVelY, String ballname) throws IOException {
		Socket receivingSocket = this.socketMap.get(receivingBoard);
    	PrintWriter recBallOut = new PrintWriter(receivingSocket.getOutputStream(), true);
		recBallOut.println("RECBALL " + ballX + " " + ballY + " " + ballVelX + " " + ballVelY + " " + ballname);
	}

	/**
     * Given a client request to join two walls of a Board or Boards together, join them together
     * 
     * @param boardName1 the first Board whose Wall we are joining
     * @param wall1 boardName1's Wall to be joined
     * @param boardName2 the second Board whose Wall we are joining
     * @param wall2 boardName2's Wall to be joined
     * @throws IOException if socket connection in wallify is unsuccessful
     */
    public void connectWalls(String boardName1, String wallLoc1, String boardName2, String wallLoc2) throws IOException {
    	
        // if the first Wall is already connected somewhere, we sever that connection (make the Wall solid)
    	if (this.wallMap.containsKey(wallLoc1 + boardName1)) {
    	    
    		String connectedWall = this.wallMap.get(wallLoc1 + boardName1);
    		if (connectedWall.startsWith("left")) {
    			wallify(connectedWall.substring(4), connectedWall.substring(0,4));
    		}
    		if (connectedWall.startsWith("right")) {
    			wallify(connectedWall.substring(5), connectedWall.substring(0,5));
    		}
    		if (connectedWall.startsWith("up")) {
    			wallify(connectedWall.substring(2), connectedWall.substring(0,2));
    		}
    		if (connectedWall.startsWith("down")) {
    			wallify(connectedWall.substring(4), connectedWall.substring(0,4));
    		}
    	}
    	
        // if the second Wall is already connected somewhere, we sever that connection (make the Wall solid)
    	if (this.wallMap.containsKey(wallLoc2 + boardName2)) {
    	    
    		String connectedWall = this.wallMap.get(wallLoc2 + boardName2);
    		if (connectedWall.startsWith("left")) {
    			wallify(connectedWall.substring(4), connectedWall.substring(0,4));
    		}
    		if (connectedWall.startsWith("right")) {
    			wallify(connectedWall.substring(5), connectedWall.substring(0,5));
    		}
    		if (connectedWall.startsWith("up")) {
    			wallify(connectedWall.substring(2), connectedWall.substring(0,2));
    		}
    		if (connectedWall.startsWith("down")) {
    			wallify(connectedWall.substring(4), connectedWall.substring(0,4));
    		}
    	}
    	
    	sendJoinMessage(boardName1, wallLoc1, boardName2);
    	sendJoinMessage(boardName2, wallLoc2, boardName1);
    	
    	this.wallMap.put(wallLoc1 + boardName1, wallLoc2 + boardName2);
    	this.wallMap.put(wallLoc2 + boardName2, wallLoc1 + boardName1);	
    }
    
    /**
     * Finds the correct socket and sends a JOINWALL message to the appropriate board's client
     * @param boardname board we are targetting
     * @param wallLoc the location of the wall we are joining
     * @param wallName the name of the board we are connecting the wall to
     * @throws IOException if socket does not connect successfully
     */
    private void sendJoinMessage(String boardName, String wallLoc, String wallName) throws IOException {
		Socket joinSocket = this.socketMap.get(boardName);
    	PrintWriter joinOut = new PrintWriter(joinSocket.getOutputStream(), true);
		joinOut.println("JOINWALL " + wallLoc + " " + wallName);
		
	}

	/**Sends a message to a board's client telling it to wallify (make solid, disconnect) a certain wall
     * @author ahochstadt
     * @param boardname the name of the board('s client) to which we are sending this WALLIFY message
     * @param wallLoc (up|down|left|right)
     * @throws IOException if socket connection is unsuccesful
     */
    public void wallify(String boardName, String wallLoc) throws IOException{
    	Socket wallifySocket = this.socketMap.get(boardName);
    	PrintWriter wallifyOut = new PrintWriter(wallifySocket.getOutputStream(), true);
    	wallifyOut.println("WALLIFY " + wallLoc);    	
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
        assert(this.wallMap != null);
        assert(this.socketMap != null);
    }

}
