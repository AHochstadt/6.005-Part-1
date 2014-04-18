import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author DylanJoss
 *
 * With regards to testing the Client/Server interaction, I found it easier to manually input the various start up commands e.g.
 * PingballClient FILE from the terminal and made sure that the observed behavior of the clients/server was consistent with the expected behavior.
 * 
 * Single-Machine Play
 * - I started up a Client with each of the sampleBoards via the command line, and ensured that the movement of the ball was consistent with the
 * specifications for the various interactions with Gadgets. Furthermore, I also tested that multiple terminal windows (i.e. clients) could 
 * engage in single-machine play simultaneously. 
 */
public class PingballClientServerTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Test
    public void test() {
        fail("Not yet implemented");
    }

}
