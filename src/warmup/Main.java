package warmup;

/**
 * TODO: put documentation for your class here
 */
public class Main {
    
    /**
     * TODO: describe your main function's command line arguments here
     */
    public static void main(String[] args) {
        Ball testBall = new Ball(5.0, 5.0, -45.0, 5.0);
        Ball[] balls = {testBall};
        
        Board testBoard = new Board(20, 20, balls);
        
        for (int i = 0; i < 200; i++) {
            System.out.println(testBoard.update(0.05));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }       
    }
}