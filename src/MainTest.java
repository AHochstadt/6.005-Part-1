import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.*;
import org.antlr.runtime.*;
import org.antlr.v4.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


//this is function generating board 
public class MainTest {

    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        /**ANTLRInputStream stream = new ANTLRInputStream(new FileReader("/Users/Catherine/Dropbox/Classes/Spring2014/6.005/pingball-phase1/src/sampleBoard1.txt"));
        BoardMakerLexer lexer = new BoardMakerLexer((org.antlr.v4.runtime.CharStream) stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BoardMakerParser parser = new BoardMakerParser((org.antlr.v4.runtime.TokenStream) tokens);
        ParseTree tree = parser.file();
        ((RuleContext)tree).inspect(parser);

        ParseTreeWalker walker = new ParseTreeWalker(); 
        MakerListener listener = new MakerListener(); 
        walker.walk(listener, tree);
        listener.getStationary();
        listener.getFlippers();
        listener.getBalls();
        System.out.println(listener.getStationary());
        System.out.println(listener.getFlippers());
        System.out.println(listener.getBalls());**/
        
        Board b = new Board("/Users/Catherine/Dropbox/Classes/Spring2014/6.005/pingball-phase1/src/sampleBoard1.txt");
        while (true) {
            Thread.sleep(50);
            b.update(0.05);
        }
    }
}
