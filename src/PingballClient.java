import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
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
 * socket: the socket with which the client is using to connect to the server
 * 
 * in: input stream from this client's socket
 * 
 * out: output stream to this client's socket
 * 
 * Rep Invariant: board may not be null
 * 
 * Thread-safety: Each Client is associated with its own Thread on the server. Therefore, a Client will never be receiving 
 *                messages from multiple Threads simultaneously. Furthermore, each Client has a Thread dedicated to handling
 *                input from the server. Lastly, all of the methods that mutate Client (wallify, joinWall, and addBall) acquire 
 *                the lock on this.board before proceeding so as to avoid concurrent mutation. 
 *
 */
public class PingballClient {

    private Board board;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    
    /**
     * Start up a new client for single-machine Pingball play
     * 
     * @param board the Board this client is using to play
     */
    public PingballClient(Board board) {
        this.board = board;
        
        checkRep();
    }
 
    /**
     * Start up a new client for client-server Pingball play
     * 
     * @param board the Board this client is using to play
     * @param socket the Socket with which the client is using to connect to the server
     * @param hostname the hostname of the server to connect to
     * @param port the port of the server to connect to
     * 
     * @throws IOException if can't connect
     */
    public PingballClient(Board board, String hostname, int port) throws IOException {
        this.board = board;
        this.socket = new Socket(hostname, port);
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        // tell the server the name of its board so the server can keep track of the active client sockets
        this.out.println("MYNAMEIS" + this.board.getBoardName());
        
        checkRep();
        
        // continuously listen for server input
        background();
    }
    
    /**
     * Listen for messages from server in the background and process them as necessary.
     * The wire protocol for the messages is described in the Javadoc of processServerInput
     */
    private void background() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                String line;
                try {
                    while ((line = in.readLine()) != null) {
                        processServerInput(line);
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
     * Parse input from the server and take appropriate action.
     * 
     * requires that line take one of the three forms
     * "RECBALL ballX ballY ballVelX ballVelY ballName" - client is receiving a ball and must instantiate it with the appropriate parameters
     *     before adding it to the Board
     *     ballX: x-coordinate of the ball to be added
     *     ballY: y-coordinate of the ball to be added
     *     ballVelX: x-component of the velocity of the ball to be added
     *     ballVelY: y-component of the velocity of the ball to be added
     *     ballName: name of the ball to be added
     * "WALLIFY wallLoc" - client is being told that one of its walls is now solid i.e. no longer connected to some other Board's wall
     *     wallLoc: the location of the wall of the client that will now be solid ("left" or "right" or "up" or "down")
     * "JOINWALL wallLoc boardName" - client is being told that one of its walls is now connected to some other Board's wall
     *     wallLoc: the location of the wall of the client that will now be permeable ("left" or "right" or "up" or "down")
     *     
     * 
     * @param line a line of input sent from the server
     */
    private void processServerInput(String line) {
        String[] lineList = line.split(" ");
        
        if (lineList[0].equals("RECBALL")) {
            Double ballX = Double.parseDouble(lineList[1]);
            Double ballY = Double.parseDouble(lineList[2]);
            Double ballVelX = Double.parseDouble(lineList[3]);
            Double ballVelY = Double.parseDouble(lineList[4]);
            String ballName = lineList[5];
            
            this.addBall(ballX, ballY, ballVelX, ballVelY, ballName);
        }
        
        else if(lineList[0].equals("WALLIFY")) {
            String wallLoc = lineList[1];
            
            this.wallify(wallLoc);
        }
        
        // JOINWALL
        else {
            String wallLoc = lineList[1];
            String boardName = lineList[2];
            
            this.joinWall(wallLoc, boardName);
        }
        
    }
    
    /**
     * Given the appropriate Ball parameters, instantiate and add a ball to the Board.
     * 
     * @param x x-coordinate of the ball to be added
     * @param y y-coordinate of the ball to be added
     * @param xVel x-component of the velocity of the ball to be added
     * @param yVel y-component of the velocity of the ball to be added
     * @param ballName name of the ball to be added
     */
    public void addBall(double x, double y, double xVel, double yVel, String ballName) {
        
        Ball ball = new Ball(x, y, xVel, yVel, ballName);
        
        synchronized(this.board) {
            this.board.addBall(ball);    
        }
    }
    
    /**
     * If a Ball will leave the current game Board, send a SENDBALL message to the server indicating as such.
     * 
     * "SENDBALL boardName wallHit ballName ballX ballY ballVelX ballVelY"
     *    boardName: the name of the Board this Ball came from
     *    wallHit: the name of the wall this Ball "hit" before exiting the Board
     *    ballX: the ball's x-coordinate
     *    ballY: the ball's y-coordinate
     *    ballVelX: the x-component of the ball's velocity
     *    ballVelY: the y-component of the ball's velocity
     * 
     * @param ball the Ball which is leaving the Board
     */
    public void sendBall(Ball ball) {
        this.out.println("SENDBALL" + " " + ball.getBoardName() + " " + ball.getWallHit() + " " + ball.getName() + " " + 
                ball.getBallVector().x() + " " + ball.getBallVector().y() + 
                " " + ball.getVelocity().x() + " " + ball.getVelocity().y());
    }
    
    /**
     * Update the wall at wallLoc of this.board to indicate it is solid.
     * 
     * @param wallLoc the location of the wall of the client that will now be solid ("left" or "right" or "up" or "down")
     */
    public void wallify(String wallLoc) {
        synchronized(this.board) {
            this.board.wallify(wallLoc);
        }
    }
    
    /**
     * Update the wall at wallLoc of this.board to indicate that it is connected to a wall of boardName.
     * 
     * @param wallLoc the location of the wall of the client that will now be permeable ("left" or "right" or "up" or "down")
     * @param boardName the name of the board to which this wall will now be connected
     */
    public void joinWall(String wallLoc, String boardName) {
        synchronized(this.board) {
            this.board.connectWall(wallLoc, boardName);
        }
    }
    
    /**
     * Return the Board being used by this PingballClient
     */
    public Board getBoard() {
        return this.board;
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
     * @param args command line arguments
     */
    public static void main(String[] args) {
        String host = null;
        int port = 10987;
        String filepath = null;
        
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
                    } else {
                        filepath = flag;
                        
                        File file = new File(filepath);
                        
                        if ( ! file.isFile()) {
                            throw new IllegalArgumentException("file not found: \"" + file + "\"");
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
            System.err.println("usage: PingballClient [--host HOST] [--port PORT] FILE");
            return;
        }

        try {
            PingballClient client;
            // Start up in single-machine play
            if (host == null) {
                client = new PingballClient(new Board(filepath));
            }
            // Start up in client-server play
            else {
                client = new PingballClient(new Board(filepath), host, port);
            }
            
            while (true) {
                synchronized(client.board) {
                    System.out.println(client.board.update(0.05));
                }
                // allow other threads access to client.board between updates
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
    
    /**
     * Ensure the rep invariant of PingballClient is maintained at all times.
     */
    private void checkRep() {
        assert(this.board != null);
    }
}
