package warmup;

public class Board {
    private final int height;
    private final int width;
    private final Ball[] components;
    
    Board(int h, int w, Ball[] components) {
        this.height = h;
        this.width = w;
        this.components = components;
    }
    
    public String Update(double timestep) {
        //TODO:  
    }
    
    /**
     * 
     * @return String representation of the boards current state
     */
    public String getBoardRep() {
        String boardRep = ""; 
        for (int j = 0; j < height; j++) {
            for (int i = 0; i <width; i++) {
                for (Ball b: components) {
                    int x = (int) Math.round(b.getX());
                    int y = (int) Math.round(b.getY());
                    if (x == i && y == j) {
                        boardRep = boardRep + ".";
                    }

                    else {
                        boardRep = boardRep + " ";
                    }
                }

                boardRep = boardRep + "\n";
            }
        }
        return boardRep;
    }

}
