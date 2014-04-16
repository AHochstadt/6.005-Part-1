// Generated from src/Expression.g4 by ANTLR 4.0

package expr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INTEGER=1, FLOAT=2, NAME=3, NAMEFIELD=4, GRAVITYFIELD=5, XFIELD=6, YFIELD=7, 
		XVELOCITYFIELD=8, YVELOCITYFIELD=9, ORIENTATIONFIELD=10, TRIGGERFIELD=11, 
		ACTIONFIELD=12, FRICTION1FIELD=13, FRICTION2FIELD=14, WIDTHFIELD=15, HEIGHTFIELD=16, 
		COMMENT=17, WHITESPACE=18;
	public static final String[] tokenNames = {
		"<INVALID>", "INTEGER", "FLOAT", "NAME", "'name='", "'gravity='", "'x='", 
		"'y='", "'xvelocity='", "'yvelocity='", "'orientation='", "'trigger='", 
		"'action='", "'friction1='", "'friction2='", "'width='", "'height='", 
		"COMMENT", "WHITESPACE"
	};
	public static final int
		RULE_board = 0, RULE_ball = 1, RULE_squareBumper = 2, RULE_circleBumper = 3, 
		RULE_triangleBumper = 4, RULE_rightFlipper = 5, RULE_leftFlipper = 6, 
		RULE_absorber = 7, RULE_fire = 8;
	public static final String[] ruleNames = {
		"board", "ball", "squareBumper", "circleBumper", "triangleBumper", "rightFlipper", 
		"leftFlipper", "absorber", "fire"
	};

	@Override
	public String getGrammarFileName() { return "Expression.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public ExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class BoardContext extends ParserRuleContext {
		public TerminalNode FRICTION2FIELD() { return getToken(ExpressionParser.FRICTION2FIELD, 0); }
		public TerminalNode FRICTION1FIELD() { return getToken(ExpressionParser.FRICTION1FIELD, 0); }
		public TerminalNode NAME() { return getToken(ExpressionParser.NAME, 0); }
		public List<TerminalNode> FLOAT() { return getTokens(ExpressionParser.FLOAT); }
		public TerminalNode NAMEFIELD() { return getToken(ExpressionParser.NAMEFIELD, 0); }
		public TerminalNode GRAVITYFIELD() { return getToken(ExpressionParser.GRAVITYFIELD, 0); }
		public TerminalNode FLOAT(int i) {
			return getToken(ExpressionParser.FLOAT, i);
		}
		public BoardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_board; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterBoard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitBoard(this);
		}
	}

	public final BoardContext board() throws RecognitionException {
		BoardContext _localctx = new BoardContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_board);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18); match(NAMEFIELD);
			setState(19); match(NAME);
			setState(20); match(GRAVITYFIELD);
			setState(21); match(FLOAT);
			setState(22); match(FRICTION1FIELD);
			setState(23); match(FLOAT);
			setState(24); match(FRICTION2FIELD);
			setState(25); match(FLOAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BallContext extends ParserRuleContext {
		public TerminalNode XVELOCITYFIELD() { return getToken(ExpressionParser.XVELOCITYFIELD, 0); }
		public TerminalNode NAME() { return getToken(ExpressionParser.NAME, 0); }
		public List<TerminalNode> FLOAT() { return getTokens(ExpressionParser.FLOAT); }
		public TerminalNode YVELOCITYFIELD() { return getToken(ExpressionParser.YVELOCITYFIELD, 0); }
		public TerminalNode YFIELD() { return getToken(ExpressionParser.YFIELD, 0); }
		public TerminalNode NAMEFIELD() { return getToken(ExpressionParser.NAMEFIELD, 0); }
		public TerminalNode XFIELD() { return getToken(ExpressionParser.XFIELD, 0); }
		public TerminalNode FLOAT(int i) {
			return getToken(ExpressionParser.FLOAT, i);
		}
		public BallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ball; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterBall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitBall(this);
		}
	}

	public final BallContext ball() throws RecognitionException {
		BallContext _localctx = new BallContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_ball);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27); match(NAMEFIELD);
			setState(28); match(NAME);
			setState(29); match(XFIELD);
			setState(30); match(FLOAT);
			setState(31); match(YFIELD);
			setState(32); match(FLOAT);
			setState(33); match(XVELOCITYFIELD);
			setState(34); match(FLOAT);
			setState(35); match(YVELOCITYFIELD);
			setState(36); match(FLOAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SquareBumperContext extends ParserRuleContext {
		public List<TerminalNode> INTEGER() { return getTokens(ExpressionParser.INTEGER); }
		public TerminalNode NAME() { return getToken(ExpressionParser.NAME, 0); }
		public TerminalNode YFIELD() { return getToken(ExpressionParser.YFIELD, 0); }
		public TerminalNode NAMEFIELD() { return getToken(ExpressionParser.NAMEFIELD, 0); }
		public TerminalNode INTEGER(int i) {
			return getToken(ExpressionParser.INTEGER, i);
		}
		public TerminalNode XFIELD() { return getToken(ExpressionParser.XFIELD, 0); }
		public SquareBumperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squareBumper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterSquareBumper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitSquareBumper(this);
		}
	}

	public final SquareBumperContext squareBumper() throws RecognitionException {
		SquareBumperContext _localctx = new SquareBumperContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_squareBumper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38); match(NAMEFIELD);
			setState(39); match(NAME);
			setState(40); match(XFIELD);
			setState(41); match(INTEGER);
			setState(42); match(YFIELD);
			setState(43); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CircleBumperContext extends ParserRuleContext {
		public List<TerminalNode> INTEGER() { return getTokens(ExpressionParser.INTEGER); }
		public TerminalNode NAME() { return getToken(ExpressionParser.NAME, 0); }
		public TerminalNode YFIELD() { return getToken(ExpressionParser.YFIELD, 0); }
		public TerminalNode NAMEFIELD() { return getToken(ExpressionParser.NAMEFIELD, 0); }
		public TerminalNode INTEGER(int i) {
			return getToken(ExpressionParser.INTEGER, i);
		}
		public TerminalNode XFIELD() { return getToken(ExpressionParser.XFIELD, 0); }
		public CircleBumperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_circleBumper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterCircleBumper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitCircleBumper(this);
		}
	}

	public final CircleBumperContext circleBumper() throws RecognitionException {
		CircleBumperContext _localctx = new CircleBumperContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_circleBumper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45); match(NAMEFIELD);
			setState(46); match(NAME);
			setState(47); match(XFIELD);
			setState(48); match(INTEGER);
			setState(49); match(YFIELD);
			setState(50); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriangleBumperContext extends ParserRuleContext {
		public List<TerminalNode> INTEGER() { return getTokens(ExpressionParser.INTEGER); }
		public TerminalNode NAME() { return getToken(ExpressionParser.NAME, 0); }
		public TerminalNode ORIENTATIONFIELD() { return getToken(ExpressionParser.ORIENTATIONFIELD, 0); }
		public TerminalNode YFIELD() { return getToken(ExpressionParser.YFIELD, 0); }
		public TerminalNode NAMEFIELD() { return getToken(ExpressionParser.NAMEFIELD, 0); }
		public TerminalNode INTEGER(int i) {
			return getToken(ExpressionParser.INTEGER, i);
		}
		public TerminalNode XFIELD() { return getToken(ExpressionParser.XFIELD, 0); }
		public TriangleBumperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triangleBumper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterTriangleBumper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitTriangleBumper(this);
		}
	}

	public final TriangleBumperContext triangleBumper() throws RecognitionException {
		TriangleBumperContext _localctx = new TriangleBumperContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_triangleBumper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52); match(NAMEFIELD);
			setState(53); match(NAME);
			setState(54); match(XFIELD);
			setState(55); match(INTEGER);
			setState(56); match(YFIELD);
			setState(57); match(INTEGER);
			setState(58); match(ORIENTATIONFIELD);
			setState(59); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RightFlipperContext extends ParserRuleContext {
		public List<TerminalNode> INTEGER() { return getTokens(ExpressionParser.INTEGER); }
		public TerminalNode NAME() { return getToken(ExpressionParser.NAME, 0); }
		public TerminalNode ORIENTATIONFIELD() { return getToken(ExpressionParser.ORIENTATIONFIELD, 0); }
		public TerminalNode YFIELD() { return getToken(ExpressionParser.YFIELD, 0); }
		public TerminalNode NAMEFIELD() { return getToken(ExpressionParser.NAMEFIELD, 0); }
		public TerminalNode INTEGER(int i) {
			return getToken(ExpressionParser.INTEGER, i);
		}
		public TerminalNode XFIELD() { return getToken(ExpressionParser.XFIELD, 0); }
		public RightFlipperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightFlipper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterRightFlipper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitRightFlipper(this);
		}
	}

	public final RightFlipperContext rightFlipper() throws RecognitionException {
		RightFlipperContext _localctx = new RightFlipperContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rightFlipper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61); match(NAMEFIELD);
			setState(62); match(NAME);
			setState(63); match(XFIELD);
			setState(64); match(INTEGER);
			setState(65); match(YFIELD);
			setState(66); match(INTEGER);
			setState(67); match(ORIENTATIONFIELD);
			setState(68); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LeftFlipperContext extends ParserRuleContext {
		public List<TerminalNode> INTEGER() { return getTokens(ExpressionParser.INTEGER); }
		public TerminalNode NAME() { return getToken(ExpressionParser.NAME, 0); }
		public TerminalNode ORIENTATIONFIELD() { return getToken(ExpressionParser.ORIENTATIONFIELD, 0); }
		public TerminalNode YFIELD() { return getToken(ExpressionParser.YFIELD, 0); }
		public TerminalNode NAMEFIELD() { return getToken(ExpressionParser.NAMEFIELD, 0); }
		public TerminalNode INTEGER(int i) {
			return getToken(ExpressionParser.INTEGER, i);
		}
		public TerminalNode XFIELD() { return getToken(ExpressionParser.XFIELD, 0); }
		public LeftFlipperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftFlipper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterLeftFlipper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitLeftFlipper(this);
		}
	}

	public final LeftFlipperContext leftFlipper() throws RecognitionException {
		LeftFlipperContext _localctx = new LeftFlipperContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_leftFlipper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70); match(NAMEFIELD);
			setState(71); match(NAME);
			setState(72); match(XFIELD);
			setState(73); match(INTEGER);
			setState(74); match(YFIELD);
			setState(75); match(INTEGER);
			setState(76); match(ORIENTATIONFIELD);
			setState(77); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbsorberContext extends ParserRuleContext {
		public List<TerminalNode> INTEGER() { return getTokens(ExpressionParser.INTEGER); }
		public TerminalNode NAME() { return getToken(ExpressionParser.NAME, 0); }
		public TerminalNode WIDTHFIELD() { return getToken(ExpressionParser.WIDTHFIELD, 0); }
		public TerminalNode YFIELD() { return getToken(ExpressionParser.YFIELD, 0); }
		public TerminalNode NAMEFIELD() { return getToken(ExpressionParser.NAMEFIELD, 0); }
		public TerminalNode HEIGHTFIELD() { return getToken(ExpressionParser.HEIGHTFIELD, 0); }
		public TerminalNode INTEGER(int i) {
			return getToken(ExpressionParser.INTEGER, i);
		}
		public TerminalNode XFIELD() { return getToken(ExpressionParser.XFIELD, 0); }
		public AbsorberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_absorber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterAbsorber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitAbsorber(this);
		}
	}

	public final AbsorberContext absorber() throws RecognitionException {
		AbsorberContext _localctx = new AbsorberContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_absorber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79); match(NAMEFIELD);
			setState(80); match(NAME);
			setState(81); match(XFIELD);
			setState(82); match(INTEGER);
			setState(83); match(YFIELD);
			setState(84); match(INTEGER);
			setState(85); match(WIDTHFIELD);
			setState(86); match(INTEGER);
			setState(87); match(HEIGHTFIELD);
			setState(88); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FireContext extends ParserRuleContext {
		public TerminalNode ACTIONFIELD() { return getToken(ExpressionParser.ACTIONFIELD, 0); }
		public List<TerminalNode> NAME() { return getTokens(ExpressionParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(ExpressionParser.NAME, i);
		}
		public TerminalNode TRIGGERFIELD() { return getToken(ExpressionParser.TRIGGERFIELD, 0); }
		public FireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fire; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterFire(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitFire(this);
		}
	}

	public final FireContext fire() throws RecognitionException {
		FireContext _localctx = new FireContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fire);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90); match(TRIGGERFIELD);
			setState(91); match(NAME);
			setState(92); match(ACTIONFIELD);
			setState(93); match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\2\3\24b\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t"+
		"\t\4\n\t\n\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\2\13\2\4\6\b\n\f\16\20\22\2"+
		"\2X\2\24\3\2\2\2\4\35\3\2\2\2\6(\3\2\2\2\b/\3\2\2\2\n\66\3\2\2\2\f?\3"+
		"\2\2\2\16H\3\2\2\2\20Q\3\2\2\2\22\\\3\2\2\2\24\25\7\6\2\2\25\26\7\5\2"+
		"\2\26\27\7\7\2\2\27\30\7\4\2\2\30\31\7\17\2\2\31\32\7\4\2\2\32\33\7\20"+
		"\2\2\33\34\7\4\2\2\34\3\3\2\2\2\35\36\7\6\2\2\36\37\7\5\2\2\37 \7\b\2"+
		"\2 !\7\4\2\2!\"\7\t\2\2\"#\7\4\2\2#$\7\n\2\2$%\7\4\2\2%&\7\13\2\2&\'\7"+
		"\4\2\2\'\5\3\2\2\2()\7\6\2\2)*\7\5\2\2*+\7\b\2\2+,\7\3\2\2,-\7\t\2\2-"+
		".\7\3\2\2.\7\3\2\2\2/\60\7\6\2\2\60\61\7\5\2\2\61\62\7\b\2\2\62\63\7\3"+
		"\2\2\63\64\7\t\2\2\64\65\7\3\2\2\65\t\3\2\2\2\66\67\7\6\2\2\678\7\5\2"+
		"\289\7\b\2\29:\7\3\2\2:;\7\t\2\2;<\7\3\2\2<=\7\f\2\2=>\7\3\2\2>\13\3\2"+
		"\2\2?@\7\6\2\2@A\7\5\2\2AB\7\b\2\2BC\7\3\2\2CD\7\t\2\2DE\7\3\2\2EF\7\f"+
		"\2\2FG\7\3\2\2G\r\3\2\2\2HI\7\6\2\2IJ\7\5\2\2JK\7\b\2\2KL\7\3\2\2LM\7"+
		"\t\2\2MN\7\3\2\2NO\7\f\2\2OP\7\3\2\2P\17\3\2\2\2QR\7\6\2\2RS\7\5\2\2S"+
		"T\7\b\2\2TU\7\3\2\2UV\7\t\2\2VW\7\3\2\2WX\7\21\2\2XY\7\3\2\2YZ\7\22\2"+
		"\2Z[\7\3\2\2[\21\3\2\2\2\\]\7\r\2\2]^\7\5\2\2^_\7\16\2\2_`\7\5\2\2`\23"+
		"\3\2\2\2\2";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}