// Generated from BoardMaker.g4 by ANTLR 4.0


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
		WHITESPACE=1, COMMENT=2, NAMEFIELD=3, GRAVITYFIELD=4, XFIELD=5, YFIELD=6, 
		XVELOCITYFIELD=7, YVELOCITYFIELD=8, ORIENTATIONFIELD=9, TRIGGERFIELD=10, 
		ACTIONFIELD=11, FRICTION1FIELD=12, FRICTION2FIELD=13, WIDTHFIELD=14, HEIGHTFIELD=15, 
		SQUAREBUMPERLABLE=16, CIRCLEBUMPERLABLE=17, TRIANGLEBUMPERLABLE=18, BOARDLABLE=19, 
		BALLLABLE=20, RIGHTFLIPPERLABLE=21, LEFTFLIPPERLABLE=22, ABSORBERLABLE=23, 
		FIRELABLE=24, INTEGER=25, FLOAT=26, NAME=27;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"WHITESPACE", "COMMENT", "NAMEFIELD", "GRAVITYFIELD", "XFIELD", "YFIELD", 
		"XVELOCITYFIELD", "YVELOCITYFIELD", "ORIENTATIONFIELD", "TRIGGERFIELD", 
		"ACTIONFIELD", "FRICTION1FIELD", "FRICTION2FIELD", "WIDTHFIELD", "HEIGHTFIELD", 
		"'squareBumper'", "'circleBumper'", "'triangleBumper'", "'board'", "'ball'", 
		"'rightFlipper'", "'leftFlipper'", "'absorber'", "'fire'", "INTEGER", 
		"FLOAT", "NAME"
	};
	public static final String[] ruleNames = {
		"WHITESPACE", "COMMENT", "NAMEFIELD", "GRAVITYFIELD", "XFIELD", "YFIELD", 
		"XVELOCITYFIELD", "YVELOCITYFIELD", "ORIENTATIONFIELD", "TRIGGERFIELD", 
		"ACTIONFIELD", "FRICTION1FIELD", "FRICTION2FIELD", "WIDTHFIELD", "HEIGHTFIELD", 
		"SQUAREBUMPERLABLE", "CIRCLEBUMPERLABLE", "TRIANGLEBUMPERLABLE", "BOARDLABLE", 
		"BALLLABLE", "RIGHTFLIPPERLABLE", "LEFTFLIPPERLABLE", "ABSORBERLABLE", 
		"FIRELABLE", "INTEGER", "FLOAT", "NAME"
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
		case 0: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;

		case 1: COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WHITESPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\35\u0195\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\6\2;\n\2\r"+
		"\2\16\2<\3\2\3\2\3\3\3\3\7\3C\n\3\f\3\16\3F\13\3\3\3\5\3I\n\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4U\n\4\f\4\16\4X\13\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5e\n\5\f\5\16\5h\13\5\3\5\3\5\3\6\3\6"+
		"\7\6n\n\6\f\6\16\6q\13\6\3\6\3\6\3\7\3\7\7\7w\n\7\f\7\16\7z\13\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0089\n\b\f\b\16\b"+
		"\u008c\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u009b"+
		"\n\t\f\t\16\t\u009e\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\7\n\u00af\n\n\f\n\16\n\u00b2\13\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00bf\n\13\f\13\16\13\u00c2\13\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00ce\n\f\f\f\16\f\u00d1"+
		"\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00e0\n"+
		"\r\f\r\16\r\u00e3\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\7\16\u00f2\n\16\f\16\16\16\u00f5\13\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0100\n\17\f\17\16\17\u0103\13\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u010f\n\20\f\20"+
		"\16\20\u0112\13\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\6"+
		"\32\u0172\n\32\r\32\16\32\u0173\3\33\5\33\u0177\n\33\3\33\6\33\u017a\n"+
		"\33\r\33\16\33\u017b\3\33\3\33\7\33\u0180\n\33\f\33\16\33\u0183\13\33"+
		"\3\33\5\33\u0186\n\33\3\33\6\33\u0189\n\33\r\33\16\33\u018a\5\33\u018d"+
		"\n\33\3\34\3\34\7\34\u0191\n\34\f\34\16\34\u0194\13\34\2\35\3\3\2\5\4"+
		"\3\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16"+
		"\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1"+
		"/\31\1\61\32\1\63\33\1\65\34\1\67\35\1\3\2\n\5\13\f\17\17\"\"\4\f\f\17"+
		"\17\3\62;\3\62;\3\62;\3\62;\5C\\aac|\6\62;C\\aac|\u01ac\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\3:\3\2\2\2\5@\3\2\2\2\7N\3\2\2"+
		"\2\t[\3\2\2\2\13k\3\2\2\2\rt\3\2\2\2\17}\3\2\2\2\21\u008f\3\2\2\2\23\u00a1"+
		"\3\2\2\2\25\u00b5\3\2\2\2\27\u00c5\3\2\2\2\31\u00d4\3\2\2\2\33\u00e6\3"+
		"\2\2\2\35\u00f8\3\2\2\2\37\u0106\3\2\2\2!\u0115\3\2\2\2#\u0122\3\2\2\2"+
		"%\u012f\3\2\2\2\'\u013e\3\2\2\2)\u0144\3\2\2\2+\u0149\3\2\2\2-\u0156\3"+
		"\2\2\2/\u0162\3\2\2\2\61\u016b\3\2\2\2\63\u0171\3\2\2\2\65\u0176\3\2\2"+
		"\2\67\u018e\3\2\2\29;\t\2\2\2:9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2"+
		"=>\3\2\2\2>?\b\2\2\2?\4\3\2\2\2@D\7%\2\2AC\n\3\2\2BA\3\2\2\2CF\3\2\2\2"+
		"DB\3\2\2\2DE\3\2\2\2EH\3\2\2\2FD\3\2\2\2GI\7\17\2\2HG\3\2\2\2HI\3\2\2"+
		"\2IJ\3\2\2\2JK\7\f\2\2KL\3\2\2\2LM\b\3\3\2M\6\3\2\2\2NO\7p\2\2OP\7c\2"+
		"\2PQ\7o\2\2QR\7g\2\2RV\3\2\2\2SU\7\"\2\2TS\3\2\2\2UX\3\2\2\2VT\3\2\2\2"+
		"VW\3\2\2\2WY\3\2\2\2XV\3\2\2\2YZ\7?\2\2Z\b\3\2\2\2[\\\7i\2\2\\]\7t\2\2"+
		"]^\7c\2\2^_\7x\2\2_`\7k\2\2`a\7v\2\2ab\7{\2\2bf\3\2\2\2ce\7\"\2\2dc\3"+
		"\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2gi\3\2\2\2hf\3\2\2\2ij\7?\2\2j\n\3"+
		"\2\2\2ko\7z\2\2ln\7\"\2\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3"+
		"\2\2\2qo\3\2\2\2rs\7?\2\2s\f\3\2\2\2tx\7{\2\2uw\7\"\2\2vu\3\2\2\2wz\3"+
		"\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2{|\7?\2\2|\16\3\2\2\2}~"+
		"\7z\2\2~\177\7X\2\2\177\u0080\7g\2\2\u0080\u0081\7n\2\2\u0081\u0082\7"+
		"q\2\2\u0082\u0083\7e\2\2\u0083\u0084\7k\2\2\u0084\u0085\7v\2\2\u0085\u0086"+
		"\7{\2\2\u0086\u008a\3\2\2\2\u0087\u0089\7\"\2\2\u0088\u0087\3\2\2\2\u0089"+
		"\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2"+
		"\2\2\u008c\u008a\3\2\2\2\u008d\u008e\7?\2\2\u008e\20\3\2\2\2\u008f\u0090"+
		"\7{\2\2\u0090\u0091\7X\2\2\u0091\u0092\7g\2\2\u0092\u0093\7n\2\2\u0093"+
		"\u0094\7q\2\2\u0094\u0095\7e\2\2\u0095\u0096\7k\2\2\u0096\u0097\7v\2\2"+
		"\u0097\u0098\7{\2\2\u0098\u009c\3\2\2\2\u0099\u009b\7\"\2\2\u009a\u0099"+
		"\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\7?\2\2\u00a0\22\3\2\2\2"+
		"\u00a1\u00a2\7q\2\2\u00a2\u00a3\7t\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5"+
		"\7g\2\2\u00a5\u00a6\7p\2\2\u00a6\u00a7\7v\2\2\u00a7\u00a8\7c\2\2\u00a8"+
		"\u00a9\7v\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab\7q\2\2\u00ab\u00ac\7p\2\2"+
		"\u00ac\u00b0\3\2\2\2\u00ad\u00af\7\"\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b2"+
		"\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b3\u00b4\7?\2\2\u00b4\24\3\2\2\2\u00b5\u00b6\7v\2\2"+
		"\u00b6\u00b7\7t\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7i\2\2\u00b9\u00ba"+
		"\7i\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc\7t\2\2\u00bc\u00c0\3\2\2\2\u00bd"+
		"\u00bf\7\"\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3"+
		"\u00c4\7?\2\2\u00c4\26\3\2\2\2\u00c5\u00c6\7c\2\2\u00c6\u00c7\7e\2\2\u00c7"+
		"\u00c8\7v\2\2\u00c8\u00c9\7k\2\2\u00c9\u00ca\7q\2\2\u00ca\u00cb\7p\2\2"+
		"\u00cb\u00cf\3\2\2\2\u00cc\u00ce\7\"\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00d1"+
		"\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d2\u00d3\7?\2\2\u00d3\30\3\2\2\2\u00d4\u00d5\7h\2\2"+
		"\u00d5\u00d6\7t\2\2\u00d6\u00d7\7k\2\2\u00d7\u00d8\7e\2\2\u00d8\u00d9"+
		"\7v\2\2\u00d9\u00da\7k\2\2\u00da\u00db\7q\2\2\u00db\u00dc\7p\2\2\u00dc"+
		"\u00dd\7\63\2\2\u00dd\u00e1\3\2\2\2\u00de\u00e0\7\"\2\2\u00df\u00de\3"+
		"\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e4\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5\7?\2\2\u00e5\32\3\2\2\2"+
		"\u00e6\u00e7\7h\2\2\u00e7\u00e8\7t\2\2\u00e8\u00e9\7k\2\2\u00e9\u00ea"+
		"\7e\2\2\u00ea\u00eb\7v\2\2\u00eb\u00ec\7k\2\2\u00ec\u00ed\7q\2\2\u00ed"+
		"\u00ee\7p\2\2\u00ee\u00ef\7\64\2\2\u00ef\u00f3\3\2\2\2\u00f0\u00f2\7\""+
		"\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\7?"+
		"\2\2\u00f7\34\3\2\2\2\u00f8\u00f9\7y\2\2\u00f9\u00fa\7k\2\2\u00fa\u00fb"+
		"\7f\2\2\u00fb\u00fc\7v\2\2\u00fc\u00fd\7j\2\2\u00fd\u0101\3\2\2\2\u00fe"+
		"\u0100\7\"\2\2\u00ff\u00fe\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2"+
		"\2\2\u0101\u0102\3\2\2\2\u0102\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104"+
		"\u0105\7?\2\2\u0105\36\3\2\2\2\u0106\u0107\7j\2\2\u0107\u0108\7g\2\2\u0108"+
		"\u0109\7k\2\2\u0109\u010a\7i\2\2\u010a\u010b\7j\2\2\u010b\u010c\7v\2\2"+
		"\u010c\u0110\3\2\2\2\u010d\u010f\7\"\2\2\u010e\u010d\3\2\2\2\u010f\u0112"+
		"\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0113\3\2\2\2\u0112"+
		"\u0110\3\2\2\2\u0113\u0114\7?\2\2\u0114 \3\2\2\2\u0115\u0116\7u\2\2\u0116"+
		"\u0117\7s\2\2\u0117\u0118\7w\2\2\u0118\u0119\7c\2\2\u0119\u011a\7t\2\2"+
		"\u011a\u011b\7g\2\2\u011b\u011c\7D\2\2\u011c\u011d\7w\2\2\u011d\u011e"+
		"\7o\2\2\u011e\u011f\7r\2\2\u011f\u0120\7g\2\2\u0120\u0121\7t\2\2\u0121"+
		"\"\3\2\2\2\u0122\u0123\7e\2\2\u0123\u0124\7k\2\2\u0124\u0125\7t\2\2\u0125"+
		"\u0126\7e\2\2\u0126\u0127\7n\2\2\u0127\u0128\7g\2\2\u0128\u0129\7D\2\2"+
		"\u0129\u012a\7w\2\2\u012a\u012b\7o\2\2\u012b\u012c\7r\2\2\u012c\u012d"+
		"\7g\2\2\u012d\u012e\7t\2\2\u012e$\3\2\2\2\u012f\u0130\7v\2\2\u0130\u0131"+
		"\7t\2\2\u0131\u0132\7k\2\2\u0132\u0133\7c\2\2\u0133\u0134\7p\2\2\u0134"+
		"\u0135\7i\2\2\u0135\u0136\7n\2\2\u0136\u0137\7g\2\2\u0137\u0138\7D\2\2"+
		"\u0138\u0139\7w\2\2\u0139\u013a\7o\2\2\u013a\u013b\7r\2\2\u013b\u013c"+
		"\7g\2\2\u013c\u013d\7t\2\2\u013d&\3\2\2\2\u013e\u013f\7d\2\2\u013f\u0140"+
		"\7q\2\2\u0140\u0141\7c\2\2\u0141\u0142\7t\2\2\u0142\u0143\7f\2\2\u0143"+
		"(\3\2\2\2\u0144\u0145\7d\2\2\u0145\u0146\7c\2\2\u0146\u0147\7n\2\2\u0147"+
		"\u0148\7n\2\2\u0148*\3\2\2\2\u0149\u014a\7t\2\2\u014a\u014b\7k\2\2\u014b"+
		"\u014c\7i\2\2\u014c\u014d\7j\2\2\u014d\u014e\7v\2\2\u014e\u014f\7H\2\2"+
		"\u014f\u0150\7n\2\2\u0150\u0151\7k\2\2\u0151\u0152\7r\2\2\u0152\u0153"+
		"\7r\2\2\u0153\u0154\7g\2\2\u0154\u0155\7t\2\2\u0155,\3\2\2\2\u0156\u0157"+
		"\7n\2\2\u0157\u0158\7g\2\2\u0158\u0159\7h\2\2\u0159\u015a\7v\2\2\u015a"+
		"\u015b\7H\2\2\u015b\u015c\7n\2\2\u015c\u015d\7k\2\2\u015d\u015e\7r\2\2"+
		"\u015e\u015f\7r\2\2\u015f\u0160\7g\2\2\u0160\u0161\7t\2\2\u0161.\3\2\2"+
		"\2\u0162\u0163\7c\2\2\u0163\u0164\7d\2\2\u0164\u0165\7u\2\2\u0165\u0166"+
		"\7q\2\2\u0166\u0167\7t\2\2\u0167\u0168\7d\2\2\u0168\u0169\7g\2\2\u0169"+
		"\u016a\7t\2\2\u016a\60\3\2\2\2\u016b\u016c\7h\2\2\u016c\u016d\7k\2\2\u016d"+
		"\u016e\7t\2\2\u016e\u016f\7g\2\2\u016f\62\3\2\2\2\u0170\u0172\t\4\2\2"+
		"\u0171\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0171\3\2\2\2\u0173\u0174"+
		"\3\2\2\2\u0174\64\3\2\2\2\u0175\u0177\7/\2\2\u0176\u0175\3\2\2\2\u0176"+
		"\u0177\3\2\2\2\u0177\u018c\3\2\2\2\u0178\u017a\t\5\2\2\u0179\u0178\3\2"+
		"\2\2\u017a\u017b\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c"+
		"\u017d\3\2\2\2\u017d\u0181\7\60\2\2\u017e\u0180\t\6\2\2\u017f\u017e\3"+
		"\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182"+
		"\u018d\3\2\2\2\u0183\u0181\3\2\2\2\u0184\u0186\7\60\2\2\u0185\u0184\3"+
		"\2\2\2\u0185\u0186\3\2\2\2\u0186\u0188\3\2\2\2\u0187\u0189\t\7\2\2\u0188"+
		"\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2"+
		"\2\2\u018b\u018d\3\2\2\2\u018c\u0179\3\2\2\2\u018c\u0185\3\2\2\2\u018d"+
		"\66\3\2\2\2\u018e\u0192\t\b\2\2\u018f\u0191\t\t\2\2\u0190\u018f\3\2\2"+
		"\2\u0191\u0194\3\2\2\2\u0192\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u01938"+
		"\3\2\2\2\u0194\u0192\3\2\2\2\33\2<DHVfox\u008a\u009c\u00b0\u00c0\u00cf"+
		"\u00e1\u00f3\u0101\u0110\u0173\u0176\u017b\u0181\u0185\u018a\u018c\u0192";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}