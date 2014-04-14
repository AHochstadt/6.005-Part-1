import static org.junit.Assert.*;

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
        testLFlipper = new LeftFlipper(1,1,1,3);
        testRFlipper = new RightFlipper(3,3,3,5);
        testCBumper = new CircularBumper(5,5);
        testSBumper = new SquareBumper(1,1,2,2);
        testTBumper = new TriangularBumper(2,2,2,1,3,2);
        testAbsorber = new Absorber(3,4,5,6);
 
    }
    
    @Test 
    public static void testLeftFlipper() {
        Ball testBall = new Ball(1.25,2.0, 180.0, 1.0, "myBoard");
        Ball effectBall = new Ball(1.25, 2.0, 0.0, 0.95, "myBoard");
        assertTrue(testLFlipper.inBounds(testBall));
        testLFlipper.getEffect(testBall);
        assertEquals(testBall, effectBall);
        
    }
    

    @Test
    public static void testRightFlipper() {
        Ball testBall = new Ball(2.75 , 4.0, 0.0, 1.0, "myBoard");
        Ball effectBall = new Ball(2.75, 4.0, 180.0, 0.95, "myBoard");
        assertTrue(testRFlipper.inBounds(testBall));
        testRFlipper.getEffect(testBall);
        assertEquals(testBall, effectBall);
        
    }

    @Test
    public static void testCircularBumper() {
        Ball testBall = new Ball(5.25, 5, 180.0, 1.0, "myBoard");
        Ball effectBall = new Ball(5.25, 5, 0.0, 1, "myBoard");
        assertTrue(testCBumper.inBounds(testBall));
        testCBumper.getEffect(testBall);
        assertEquals(testBall, effectBall);
        
    }
    
    @Test
    public static void testSquareBumper() {
        Ball testBall = new Ball(2.25, 1.5, 180.0, 1.0, "myBoard");
        Ball effectBall = new Ball(2.25, 1.5, 0.0, 1.0, "myBoard");
        assertTrue(testSBumper.inBounds(testBall));
        testSBumper.getEffect(testBall);
        assertEquals(testBall, effectBall);
        
    }
    
    @Test 
    public static void testTraingularBumper() {
        Ball testBall = new Ball(1.75, 1.5, 0.0, 1.0, "myBoard");
        Ball effectBall = new Ball(1.75, 1.5, 180.0, 1, "myBoard");
        assertTrue(testCBumper.inBounds(testBall));
        testCBumper.getEffect(testBall);
        assertEquals(testBall, effectBall);
        
    }
    
    @Test
    public static void testAbsorber() {
        
    }
    
    


    }

