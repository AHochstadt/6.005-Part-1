import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.*;
import org.antlr.runtime.*;
import org.antlr.v4.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


//this is function generating board 
public class MainTest {
    //make input stream with file reader 
    MainTest(File file) throws FileNotFoundException, IOException {

        CharStream stream = (CharStream) new ANTLRInputStream(new FileReader(file));
        BoardMakerLexer lexer = new BoardMakerLexer((org.antlr.v4.runtime.CharStream) stream);
        TokenStream tokens = new CommonTokenStream((TokenSource) lexer);
        BoardMakerParser parser = new BoardMakerParser((org.antlr.v4.runtime.TokenStream) tokens);
        ParseTree tree = parser.file();
        ((RuleContext)tree).inspect(parser);

        ParseTreeWalker walker = new ParseTreeWalker(); 
        MakerListener listener = new MakerListener(); 
        walker.walk(listener, tree);
        listener.getStationary();
        listener.getFlippers();
        listener.getBalls();
    }
    
    public void main() throws FileNotFoundException, IOException {
        CharStream stream = (CharStream) new ANTLRInputStream(new FileReader("sampleBoard1.txt"));
        BoardMakerLexer lexer = new BoardMakerLexer((org.antlr.v4.runtime.CharStream) stream);
        TokenStream tokens = new CommonTokenStream((TokenSource) lexer);
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
    }
}
