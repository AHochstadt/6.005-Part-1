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

import org.antlr.*;
import org.antlr.runtime.*;
import org.antlr.v4.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * 
 * @author DylanJoss
 *
 * A class representing a Pingball client
 * 
 * board: the Board instance this client is using to play
 * 
 * queue: the queue on the server that contains messages from Clients
 *
 */
public class PingballClient {

    private Board board;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    
    /**
     * Start up a new client for single-machine Pingball 
     * 
     * @param board the Board this client is using to play
     * @param hostname the hostname of the server to connect to
     * @param port the port of the server to connect to
     */
    public PingballClient(Board board) {
        this.board = board;
        this.socket = null;
        this.in = null;
        this.out = null;
    }
 
    /**
     * Start up a new client for client-machine Pingball 
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
        this.socket = new Socket(hostname, port);
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        // tell the server the name of its board 
        this.out.println("MYNAMEIS" + this.board.getBoardName());
        
        background();
    }
    
    /**
     * Listen for messages from server
     */
    public void background() {
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
     * Parse input from the server 
     * 
     * requires that line take one of the two forms
     * "RECBALL ballX ballY ballVelX ballVelY ballName"
     * "WALLIFY wallLoc"
     */
    public void processServerInput(String line) {
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
        
        else {
            String wallLoc = lineList[1];
            String boardName = lineList[2];
            
            this.joinWall(wallLoc, boardName);
        }
        
    }
    
    /**
     * Add a ball to the board
     */
    public void addBall(double x, double y, double xVel, double yVel, String ballName) {
        
        Ball ball = new Ball(x, y, xVel, yVel, ballName);
        this.board.addBall(ball);    
    }
    
    /**
     * If a Ball will leave the current game Board, send a board message to the server
     */
    public void sendBall(Ball ball) {
        this.out.println("SENDBALL" + " " + ball.getBoardName() + " " + ball.getWallHit() + " " + ball.getName() + " " + ball.getX() + " " + ball.getY() +
                " " + ball.getBallVector().x() + " " + ball.getBallVector().y());
    }
    
    /**
     * Update the wall at wallLoc of this.board to indicate it is solid
     */
    public void wallify(String wallLoc) {
        this.board.wallify(wallLoc);
    }
    
    /**
     * Update the wall at wallLoc of this.board to indicate that it is connected to a wall of boardName
     */
    public void joinWall(String wallLoc, String boardName) {
        this.board.connectWall(wallLoc, boardName);
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
                        
//                        try {
//                            Board board = new Board(filepath);
//                        } catch (IOException e) {
//                            // TODO Auto-generated catch block
//                            e.printStackTrace();
//                        }
                                                
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
            PingballClient client;
            //Board b = new Board("/Users/DylanJoss/Documents/MIT Spring 2014/6.005/pingball-phase1/src/sampleBoard1.txt");
            if (host == null) {
                // TODO: start up this client in single-machine play
                client = new PingballClient(new Board(filepath));
                //client = new PingballClient(b);
            }
            else {
                // TODO: connect to the server and start up this client in client-server play
                client = new PingballClient(new Board(filepath), host, port);
                //client = new PingballClient(b, host, port);
            }
            
            while (true) {
                System.out.println(client.board.update(0.05));
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
}
