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
		INTEGER=1, FLOAT=2, NAME=3, NAMEFIELD=4, GRAVITYFIELD=5, XFIELD=6, YFIELD=7, 
		XVELOCITYFIELD=8, YVELOCITYFIELD=9, ORIENTATIONFIELD=10, TRIGGERFIELD=11, 
		ACTIONFIELD=12, FRICTION1FIELD=13, FRICTION2FIELD=14, WIDTHFIELD=15, HEIGHTFIELD=16, 
		SQUAREBUMPERLABLE=17, CIRCLEBUMPERLABLE=18, TRIANGLEBUMPERLABLE=19, BOARDLABLE=20, 
		BALLLABLE=21, RIGHTFLIPPERLABLE=22, LEFTFLIPPERLABLE=23, ABSORBERLABLE=24, 
		FIRELABLE=25, COMMENT=26, WHITESPACE=27;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"INTEGER", "FLOAT", "NAME", "'name='", "'gravity='", "'x='", "'y='", "'xvelocity='", 
		"'yvelocity='", "'orientation='", "'trigger='", "'action='", "'friction1='", 
		"'friction2='", "'width='", "'height='", "'squareBumper'", "'circleBumper'", 
		"'triangleBumper'", "'board'", "'ball'", "'rightFlipper'", "'leftFlipper'", 
		"'absorber'", "'fire'", "COMMENT", "WHITESPACE"
	};
	public static final String[] ruleNames = {
		"INTEGER", "FLOAT", "NAME", "NAMEFIELD", "GRAVITYFIELD", "XFIELD", "YFIELD", 
		"XVELOCITYFIELD", "YVELOCITYFIELD", "ORIENTATIONFIELD", "TRIGGERFIELD", 
		"ACTIONFIELD", "FRICTION1FIELD", "FRICTION2FIELD", "WIDTHFIELD", "HEIGHTFIELD", 
		"SQUAREBUMPERLABLE", "CIRCLEBUMPERLABLE", "TRIANGLEBUMPERLABLE", "BOARDLABLE", 
		"BALLLABLE", "RIGHTFLIPPERLABLE", "LEFTFLIPPERLABLE", "ABSORBERLABLE", 
		"FIRELABLE", "COMMENT", "WHITESPACE"
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
		case 25: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 26: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;
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
		"\2\4\35\u013c\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\6\2;\n\2\r"+
		"\2\16\2<\3\3\5\3@\n\3\3\3\6\3C\n\3\r\3\16\3D\3\3\3\3\7\3I\n\3\f\3\16\3"+
		"L\13\3\3\3\5\3O\n\3\3\3\6\3R\n\3\r\3\16\3S\5\3V\n\3\3\4\3\4\7\4Z\n\4\f"+
		"\4\16\4]\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\7\33\u012a"+
		"\n\33\f\33\16\33\u012d\13\33\3\33\5\33\u0130\n\33\3\33\3\33\3\33\3\33"+
		"\3\34\6\34\u0137\n\34\r\34\16\34\u0138\3\34\3\34\2\35\3\3\1\5\4\1\7\5"+
		"\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17"+
		"\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61"+
		"\32\1\63\33\1\65\34\2\67\35\3\3\2\n\3\62;\3\62;\3\62;\3\62;\5C\\aac|\6"+
		"\62;C\\aac|\4\f\f\17\17\5\13\f\17\17\"\"\u0146\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\3:\3\2\2\2\5?\3\2\2\2\7W\3\2\2\2\t^\3\2"+
		"\2\2\13d\3\2\2\2\rm\3\2\2\2\17p\3\2\2\2\21s\3\2\2\2\23~\3\2\2\2\25\u0089"+
		"\3\2\2\2\27\u0096\3\2\2\2\31\u009f\3\2\2\2\33\u00a7\3\2\2\2\35\u00b2\3"+
		"\2\2\2\37\u00bd\3\2\2\2!\u00c4\3\2\2\2#\u00cc\3\2\2\2%\u00d9\3\2\2\2\'"+
		"\u00e6\3\2\2\2)\u00f5\3\2\2\2+\u00fb\3\2\2\2-\u0100\3\2\2\2/\u010d\3\2"+
		"\2\2\61\u0119\3\2\2\2\63\u0122\3\2\2\2\65\u0127\3\2\2\2\67\u0136\3\2\2"+
		"\29;\t\2\2\2:9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\4\3\2\2\2>@\7/\2"+
		"\2?>\3\2\2\2?@\3\2\2\2@U\3\2\2\2AC\t\3\2\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2"+
		"\2DE\3\2\2\2EF\3\2\2\2FJ\7\60\2\2GI\t\4\2\2HG\3\2\2\2IL\3\2\2\2JH\3\2"+
		"\2\2JK\3\2\2\2KV\3\2\2\2LJ\3\2\2\2MO\7\60\2\2NM\3\2\2\2NO\3\2\2\2OQ\3"+
		"\2\2\2PR\t\5\2\2QP\3\2\2\2RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2\2\2UB\3"+
		"\2\2\2UN\3\2\2\2V\6\3\2\2\2W[\t\6\2\2XZ\t\7\2\2YX\3\2\2\2Z]\3\2\2\2[Y"+
		"\3\2\2\2[\\\3\2\2\2\\\b\3\2\2\2][\3\2\2\2^_\7p\2\2_`\7c\2\2`a\7o\2\2a"+
		"b\7g\2\2bc\7?\2\2c\n\3\2\2\2de\7i\2\2ef\7t\2\2fg\7c\2\2gh\7x\2\2hi\7k"+
		"\2\2ij\7v\2\2jk\7{\2\2kl\7?\2\2l\f\3\2\2\2mn\7z\2\2no\7?\2\2o\16\3\2\2"+
		"\2pq\7{\2\2qr\7?\2\2r\20\3\2\2\2st\7z\2\2tu\7x\2\2uv\7g\2\2vw\7n\2\2w"+
		"x\7q\2\2xy\7e\2\2yz\7k\2\2z{\7v\2\2{|\7{\2\2|}\7?\2\2}\22\3\2\2\2~\177"+
		"\7{\2\2\177\u0080\7x\2\2\u0080\u0081\7g\2\2\u0081\u0082\7n\2\2\u0082\u0083"+
		"\7q\2\2\u0083\u0084\7e\2\2\u0084\u0085\7k\2\2\u0085\u0086\7v\2\2\u0086"+
		"\u0087\7{\2\2\u0087\u0088\7?\2\2\u0088\24\3\2\2\2\u0089\u008a\7q\2\2\u008a"+
		"\u008b\7t\2\2\u008b\u008c\7k\2\2\u008c\u008d\7g\2\2\u008d\u008e\7p\2\2"+
		"\u008e\u008f\7v\2\2\u008f\u0090\7c\2\2\u0090\u0091\7v\2\2\u0091\u0092"+
		"\7k\2\2\u0092\u0093\7q\2\2\u0093\u0094\7p\2\2\u0094\u0095\7?\2\2\u0095"+
		"\26\3\2\2\2\u0096\u0097\7v\2\2\u0097\u0098\7t\2\2\u0098\u0099\7k\2\2\u0099"+
		"\u009a\7i\2\2\u009a\u009b\7i\2\2\u009b\u009c\7g\2\2\u009c\u009d\7t\2\2"+
		"\u009d\u009e\7?\2\2\u009e\30\3\2\2\2\u009f\u00a0\7c\2\2\u00a0\u00a1\7"+
		"e\2\2\u00a1\u00a2\7v\2\2\u00a2\u00a3\7k\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5"+
		"\7p\2\2\u00a5\u00a6\7?\2\2\u00a6\32\3\2\2\2\u00a7\u00a8\7h\2\2\u00a8\u00a9"+
		"\7t\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab\7e\2\2\u00ab\u00ac\7v\2\2\u00ac"+
		"\u00ad\7k\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7p\2\2\u00af\u00b0\7\63\2"+
		"\2\u00b0\u00b1\7?\2\2\u00b1\34\3\2\2\2\u00b2\u00b3\7h\2\2\u00b3\u00b4"+
		"\7t\2\2\u00b4\u00b5\7k\2\2\u00b5\u00b6\7e\2\2\u00b6\u00b7\7v\2\2\u00b7"+
		"\u00b8\7k\2\2\u00b8\u00b9\7q\2\2\u00b9\u00ba\7p\2\2\u00ba\u00bb\7\64\2"+
		"\2\u00bb\u00bc\7?\2\2\u00bc\36\3\2\2\2\u00bd\u00be\7y\2\2\u00be\u00bf"+
		"\7k\2\2\u00bf\u00c0\7f\2\2\u00c0\u00c1\7v\2\2\u00c1\u00c2\7j\2\2\u00c2"+
		"\u00c3\7?\2\2\u00c3 \3\2\2\2\u00c4\u00c5\7j\2\2\u00c5\u00c6\7g\2\2\u00c6"+
		"\u00c7\7k\2\2\u00c7\u00c8\7i\2\2\u00c8\u00c9\7j\2\2\u00c9\u00ca\7v\2\2"+
		"\u00ca\u00cb\7?\2\2\u00cb\"\3\2\2\2\u00cc\u00cd\7u\2\2\u00cd\u00ce\7s"+
		"\2\2\u00ce\u00cf\7w\2\2\u00cf\u00d0\7c\2\2\u00d0\u00d1\7t\2\2\u00d1\u00d2"+
		"\7g\2\2\u00d2\u00d3\7D\2\2\u00d3\u00d4\7w\2\2\u00d4\u00d5\7o\2\2\u00d5"+
		"\u00d6\7r\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8\7t\2\2\u00d8$\3\2\2\2\u00d9"+
		"\u00da\7e\2\2\u00da\u00db\7k\2\2\u00db\u00dc\7t\2\2\u00dc\u00dd\7e\2\2"+
		"\u00dd\u00de\7n\2\2\u00de\u00df\7g\2\2\u00df\u00e0\7D\2\2\u00e0\u00e1"+
		"\7w\2\2\u00e1\u00e2\7o\2\2\u00e2\u00e3\7r\2\2\u00e3\u00e4\7g\2\2\u00e4"+
		"\u00e5\7t\2\2\u00e5&\3\2\2\2\u00e6\u00e7\7v\2\2\u00e7\u00e8\7t\2\2\u00e8"+
		"\u00e9\7k\2\2\u00e9\u00ea\7c\2\2\u00ea\u00eb\7p\2\2\u00eb\u00ec\7i\2\2"+
		"\u00ec\u00ed\7n\2\2\u00ed\u00ee\7g\2\2\u00ee\u00ef\7D\2\2\u00ef\u00f0"+
		"\7w\2\2\u00f0\u00f1\7o\2\2\u00f1\u00f2\7r\2\2\u00f2\u00f3\7g\2\2\u00f3"+
		"\u00f4\7t\2\2\u00f4(\3\2\2\2\u00f5\u00f6\7d\2\2\u00f6\u00f7\7q\2\2\u00f7"+
		"\u00f8\7c\2\2\u00f8\u00f9\7t\2\2\u00f9\u00fa\7f\2\2\u00fa*\3\2\2\2\u00fb"+
		"\u00fc\7d\2\2\u00fc\u00fd\7c\2\2\u00fd\u00fe\7n\2\2\u00fe\u00ff\7n\2\2"+
		"\u00ff,\3\2\2\2\u0100\u0101\7t\2\2\u0101\u0102\7k\2\2\u0102\u0103\7i\2"+
		"\2\u0103\u0104\7j\2\2\u0104\u0105\7v\2\2\u0105\u0106\7H\2\2\u0106\u0107"+
		"\7n\2\2\u0107\u0108\7k\2\2\u0108\u0109\7r\2\2\u0109\u010a\7r\2\2\u010a"+
		"\u010b\7g\2\2\u010b\u010c\7t\2\2\u010c.\3\2\2\2\u010d\u010e\7n\2\2\u010e"+
		"\u010f\7g\2\2\u010f\u0110\7h\2\2\u0110\u0111\7v\2\2\u0111\u0112\7H\2\2"+
		"\u0112\u0113\7n\2\2\u0113\u0114\7k\2\2\u0114\u0115\7r\2\2\u0115\u0116"+
		"\7r\2\2\u0116\u0117\7g\2\2\u0117\u0118\7t\2\2\u0118\60\3\2\2\2\u0119\u011a"+
		"\7c\2\2\u011a\u011b\7d\2\2\u011b\u011c\7u\2\2\u011c\u011d\7q\2\2\u011d"+
		"\u011e\7t\2\2\u011e\u011f\7d\2\2\u011f\u0120\7g\2\2\u0120\u0121\7t\2\2"+
		"\u0121\62\3\2\2\2\u0122\u0123\7h\2\2\u0123\u0124\7k\2\2\u0124\u0125\7"+
		"t\2\2\u0125\u0126\7g\2\2\u0126\64\3\2\2\2\u0127\u012b\7%\2\2\u0128\u012a"+
		"\n\b\2\2\u0129\u0128\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b"+
		"\u012c\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u0130\7\17"+
		"\2\2\u012f\u012e\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\3\2\2\2\u0131"+
		"\u0132\7\f\2\2\u0132\u0133\3\2\2\2\u0133\u0134\b\33\2\2\u0134\66\3\2\2"+
		"\2\u0135\u0137\t\t\2\2\u0136\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0136"+
		"\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013b\b\34\3\2"+
		"\u013b8\3\2\2\2\16\2<?DJNSU[\u012b\u012f\u0138";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}