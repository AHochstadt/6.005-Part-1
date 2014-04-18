import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * @author DylanJoss
 *
 * A class representing a Pingball client
 * 
 * board: the Board instance this client is using to play
 * 
 * queue: the queue on the server that contains the Balls that left board
 *
 */
public class PingballClient {

    private Board board;
    //private final BlockingQueue<Ball> queue; 
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    
    public PingballClient(Board board) {
        this.board = board;
    }
 
    /**
     * Start up a new client playing Pingball 
     * 
     * @param board the Board this client is using to play
     * @param queue the queue the server uses for processing Balls that have left some Client's Board
     *        and will enter some other Client's board
     * @param hostname the hostname of the server to connect to
     * @param port the port of the server to connect to
     * 
     * @throws IOException if can't connect
     */
    public PingballClient(Board board, String hostname, int port) throws IOException {
        this.board = board;
        //this.queue = queue;  
        this.socket = new Socket(hostname, port);
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
    }
    
    public void background() {
        
        
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
        
        while (true) {
            // call this.board.update()
        }
    }
    
    /**
     * Assign board to be the Board this client uses in playing Pingball
     * 
     * @param board the Board this client will use in playing Pingball
     */
    public void setBoard(Board board) {
        this.board = board;
    }
    
    /**
     * Given a message from the server that a new Ball is to enter this.board, add it to the board
     */
    public void addBall() {
        
    }
    
    /**
     * If a Ball will leave the current game Board, add it to the server's queue
     */
    public void sendBall(Ball ball) {
        this.queue.add(ball);
        this.board.removeBall(ball);
    }
    
    /**
     * Update the walls of this.board to indicate new connections or that old connections are no longer in place
     */
    public void updateWalls() {
        
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
                    } else if (flag.equals("--file")) {
                        filepath = arguments.remove();
                        
                        try {
                            Board board = new Board(filepath);
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
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
            System.err.println("usage: PingballClient [--host HOST] [--port PORT] FILE");
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
