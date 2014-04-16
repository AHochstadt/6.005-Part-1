import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.*;



public class BoardConstructTest {
	/**
	 * @author ahochstadt
	 * Tests if Board correctly constructs sample board 1
	 * @throws IOException 
	 */
	@Test public void testSampleBoard1() throws IOException{
		Board board1 = new Board("http://web.mit.edu/6.005/www/sp14/projects/gb1/boards/sampleBoard1.pb");
		assertEquals(board1.getBoardRep(),"......................\r\n.                    .\r\n.                    .\r\n.########|  |########.\r\n.    O          O    .\r\n.     O        O     .\r\n.      O      O      .\r\n.       O    O       .\r\n.        |  |        .\r\n.        \\  /        .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.====================.\r\n......................");
	}
	/**
	 * @author ahochstadt
	 * Tests if Board correctly constructs sample board 2_1
	 * @throws IOException 
	 */
	@Test public void testSampleBoard2_1() throws IOException{
		Board board2_1 = new Board("http://web.mit.edu/6.005/www/sp14/projects/gb1/boards/sampleBoard2-1.pb");
		assertEquals(board2_1.getBoardRep(),"......................\r\n.*                   .\r\n.                    .\r\n.################|   .\r\n.          O         .\r\n.           O        .\r\n.            O       .\r\n.             O      .\r\n.              O     .\r\n.               O    .\r\n.                |   .\r\n.                 \\  .\r\n.                  \\ .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.====================.\r\n......................");
	}
	/**
	 * @author ahochstadt
	 * Tests if Board correctly constructs sample board 2_2
	 * @throws IOException 
	 */
	@Test public void testSampleBoard2_2() throws IOException{
		Board board2_2 = new Board("http://web.mit.edu/6.005/www/sp14/projects/gb1/boards/sampleBoard2-1.pb");
		assertEquals(board2_2.getBoardRep(), "......................\r\n.                    .\r\n.                    .\r\n.   |################.\r\n.         O          .\r\n.        O           .\r\n.       O            .\r\n.      O             .\r\n.     O              .\r\n.    O               .\r\n.   |                .\r\n.  /                 .\r\n. /                  .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.====================.\r\n......................");
	}
	/**
	 * @author ahochstadt
	 * Tests if Board correctly constructs sample board 3
	 * @throws IOException 
	 */
	@Test public void testSampleBoard3() throws IOException{
		Board board3 = new Board("http://web.mit.edu/6.005/www/sp14/projects/gb1/boards/sampleBoard3.pb");
		assertEquals(board3.getBoardRep(), "......................\r\n.                    .\r\n.                    .\r\n.                    .\r\n.    O              \\.\r\n.                    .\r\n.                    .\r\n.                    .\r\n.          | |       .\r\n.                    .\r\n.                    .\r\n.########            .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.                    .\r\n.====================.\r\n.====================.\r\n.                    .\r\n......................");
	}
	
	/**
	 * @author ahochstadt
	 * Tests if Board correctly constructs sample board 4
	 * @throws IOException 
	 */
	@Test public void testSampleBoard4() throws IOException{
		Board board4 = new Board("http://web.mit.edu/6.005/www/sp14/projects/gb1/boards/sampleBoard4.pb");
		assertEquals(board4.getBoardRep(), "......................\n.                    .\n.                    .\n.                    .\n.    O              \\.\n.                    .\n.                    .\n.                    .\n.          - -       .\n.                    .\n.                    .\n.####                .\n.                    .\n.                    .\n.                    .\n.                    .\n.                    .\n.                    .\n.====================.\n.====================.\n.                    .\n......................");
	}
}