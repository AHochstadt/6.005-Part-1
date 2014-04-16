// Generated from src/BoardMaker.g4 by ANTLR 4.0


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BoardMakerLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INTEGER=1, FLOAT=2, NAME=3, NAMEFIELD=4, GRAVITYFIELD=5, XFIELD=6, YFIELD=7, 
		XVELOCITYFIELD=8, YVELOCITYFIELD=9, ORIENTATIONFIELD=10, TRIGGERFIELD=11, 
		ACTIONFIELD=12, FRICTION1FIELD=13, FRICTION2FIELD=14, WIDTHFIELD=15, HEIGHTFIELD=16, 
		COMMENT=17, WHITESPACE=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"INTEGER", "FLOAT", "NAME", "'name='", "'gravity='", "'x='", "'y='", "'xvelocity='", 
		"'yvelocity='", "'orientation='", "'trigger='", "'action='", "'friction1='", 
		"'friction2='", "'width='", "'height='", "COMMENT", "WHITESPACE"
	};
	public static final String[] ruleNames = {
		"INTEGER", "FLOAT", "NAME", "NAMEFIELD", "GRAVITYFIELD", "XFIELD", "YFIELD", 
		"XVELOCITYFIELD", "YVELOCITYFIELD", "ORIENTATIONFIELD", "TRIGGERFIELD", 
		"ACTIONFIELD", "FRICTION1FIELD", "FRICTION2FIELD", "WIDTHFIELD", "HEIGHTFIELD", 
		"COMMENT", "WHITESPACE"
	};


	    /**
	     * Call this method to have the lexer or parser throw a RuntimeException if
	     * it encounters an error.
	     */
	    public void reportErrorsAsExceptions() {
	        addErrorListener(new ExceptionThrowingErrorListener());
	    }
	    
	    private static class ExceptionThrowingErrorListener extends BaseErrorListener {
	        @Override
	        public void syntaxError(Recognizer<?, ?> recognizer,
	                Object offendingSymbol, int line, int charPositionInLine,
	                String msg, RecognitionException e) {
	            throw new RuntimeException(msg);
	        }
	    }


	public BoardMakerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BoardMaker.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 16: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 17: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WHITESPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\24\u00c9\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\3\2\6\2)\n\2\r\2\16\2*\3\3\5\3.\n"+
		"\3\3\3\6\3\61\n\3\r\3\16\3\62\3\3\3\3\7\3\67\n\3\f\3\16\3:\13\3\3\3\5"+
		"\3=\n\3\3\3\6\3@\n\3\r\3\16\3A\5\3D\n\3\3\4\3\4\7\4H\n\4\f\4\16\4K\13"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\6\22\u00bd\n\22\r\22\16\22\u00be\3\22\3\22\3\23\6\23\u00c4"+
		"\n\23\r\23\16\23\u00c5\3\23\3\23\2\24\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r"+
		"\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21"+
		"\1!\22\1#\23\2%\24\3\3\2\n\3\62;\3\62;\3\62;\3\62;\5C\\aac|\6\62;C\\a"+
		"ac|\5\13\f\17\17\"\"\5\13\f\17\17\"\"\u00d2\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3(\3\2\2\2"+
		"\5-\3\2\2\2\7E\3\2\2\2\tL\3\2\2\2\13R\3\2\2\2\r[\3\2\2\2\17^\3\2\2\2\21"+
		"a\3\2\2\2\23l\3\2\2\2\25w\3\2\2\2\27\u0084\3\2\2\2\31\u008d\3\2\2\2\33"+
		"\u0095\3\2\2\2\35\u00a0\3\2\2\2\37\u00ab\3\2\2\2!\u00b2\3\2\2\2#\u00ba"+
		"\3\2\2\2%\u00c3\3\2\2\2\')\t\2\2\2(\'\3\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3"+
		"\2\2\2+\4\3\2\2\2,.\7/\2\2-,\3\2\2\2-.\3\2\2\2.C\3\2\2\2/\61\t\3\2\2\60"+
		"/\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\648"+
		"\7\60\2\2\65\67\t\4\2\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2"+
		"\29D\3\2\2\2:8\3\2\2\2;=\7\60\2\2<;\3\2\2\2<=\3\2\2\2=?\3\2\2\2>@\t\5"+
		"\2\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2C\60\3\2\2\2C<\3"+
		"\2\2\2D\6\3\2\2\2EI\t\6\2\2FH\t\7\2\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ"+
		"\3\2\2\2J\b\3\2\2\2KI\3\2\2\2LM\7p\2\2MN\7c\2\2NO\7o\2\2OP\7g\2\2PQ\7"+
		"?\2\2Q\n\3\2\2\2RS\7i\2\2ST\7t\2\2TU\7c\2\2UV\7x\2\2VW\7k\2\2WX\7v\2\2"+
		"XY\7{\2\2YZ\7?\2\2Z\f\3\2\2\2[\\\7z\2\2\\]\7?\2\2]\16\3\2\2\2^_\7{\2\2"+
		"_`\7?\2\2`\20\3\2\2\2ab\7z\2\2bc\7x\2\2cd\7g\2\2de\7n\2\2ef\7q\2\2fg\7"+
		"e\2\2gh\7k\2\2hi\7v\2\2ij\7{\2\2jk\7?\2\2k\22\3\2\2\2lm\7{\2\2mn\7x\2"+
		"\2no\7g\2\2op\7n\2\2pq\7q\2\2qr\7e\2\2rs\7k\2\2st\7v\2\2tu\7{\2\2uv\7"+
		"?\2\2v\24\3\2\2\2wx\7q\2\2xy\7t\2\2yz\7k\2\2z{\7g\2\2{|\7p\2\2|}\7v\2"+
		"\2}~\7c\2\2~\177\7v\2\2\177\u0080\7k\2\2\u0080\u0081\7q\2\2\u0081\u0082"+
		"\7p\2\2\u0082\u0083\7?\2\2\u0083\26\3\2\2\2\u0084\u0085\7v\2\2\u0085\u0086"+
		"\7t\2\2\u0086\u0087\7k\2\2\u0087\u0088\7i\2\2\u0088\u0089\7i\2\2\u0089"+
		"\u008a\7g\2\2\u008a\u008b\7t\2\2\u008b\u008c\7?\2\2\u008c\30\3\2\2\2\u008d"+
		"\u008e\7c\2\2\u008e\u008f\7e\2\2\u008f\u0090\7v\2\2\u0090\u0091\7k\2\2"+
		"\u0091\u0092\7q\2\2\u0092\u0093\7p\2\2\u0093\u0094\7?\2\2\u0094\32\3\2"+
		"\2\2\u0095\u0096\7h\2\2\u0096\u0097\7t\2\2\u0097\u0098\7k\2\2\u0098\u0099"+
		"\7e\2\2\u0099\u009a\7v\2\2\u009a\u009b\7k\2\2\u009b\u009c\7q\2\2\u009c"+
		"\u009d\7p\2\2\u009d\u009e\7\63\2\2\u009e\u009f\7?\2\2\u009f\34\3\2\2\2"+
		"\u00a0\u00a1\7h\2\2\u00a1\u00a2\7t\2\2\u00a2\u00a3\7k\2\2\u00a3\u00a4"+
		"\7e\2\2\u00a4\u00a5\7v\2\2\u00a5\u00a6\7k\2\2\u00a6\u00a7\7q\2\2\u00a7"+
		"\u00a8\7p\2\2\u00a8\u00a9\7\64\2\2\u00a9\u00aa\7?\2\2\u00aa\36\3\2\2\2"+
		"\u00ab\u00ac\7y\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7f\2\2\u00ae\u00af"+
		"\7v\2\2\u00af\u00b0\7j\2\2\u00b0\u00b1\7?\2\2\u00b1 \3\2\2\2\u00b2\u00b3"+
		"\7j\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7k\2\2\u00b5\u00b6\7i\2\2\u00b6"+
		"\u00b7\7j\2\2\u00b7\u00b8\7v\2\2\u00b8\u00b9\7?\2\2\u00b9\"\3\2\2\2\u00ba"+
		"\u00bc\7%\2\2\u00bb\u00bd\t\b\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00be\3\2"+
		"\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00c1\b\22\2\2\u00c1$\3\2\2\2\u00c2\u00c4\t\t\2\2\u00c3\u00c2\3\2\2\2"+
		"\u00c4\u00c5\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7"+
		"\3\2\2\2\u00c7\u00c8\b\23\3\2\u00c8&\3\2\2\2\r\2*-\628<ACI\u00be\u00c5";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}