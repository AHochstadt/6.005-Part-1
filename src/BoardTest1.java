import org.junit.*;
/**
 * 
 * Tests functions and interaction of the gadgets of the board.  
 * @author Lauren 
 *
 */
public class BoardTest1 {
    
    private static LeftFlipper testLFlipper;
    private static RightFlipper testRFlipper;
    private static CircularBumper testCBumper;
    private static SquareBumper testSBumper;
    private static TriangularBumper testTBumper;
    private static Absorber testAbsorber; 
    
    @BeforeClass 
    public static void setUpBeforeClass() {
        testLFlipper = new LeftFlipper(1,1,2,2);
        testRFlipper = new RightFlipper(2,2,4,4);
        testCBumper = new CircularBumper(5,5);
        testSBumper = new SquareBumper(1,1,2,2);
        testTBumper = new TriangularBumper(3,3,6,6);
        testAbsorber = new Absorber(3,4,5,6);
        

        
    }


    
    


    }

