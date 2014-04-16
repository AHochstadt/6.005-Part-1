// Generated from src/BoardMaker.g4 by ANTLR 4.0


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BoardMakerParser extends Parser {
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
		RULE_file = 0, RULE_board = 1, RULE_ball = 2, RULE_squareBumper = 3, RULE_circleBumper = 4, 
		RULE_triangleBumper = 5, RULE_rightFlipper = 6, RULE_leftFlipper = 7, 
		RULE_absorber = 8, RULE_fire = 9, RULE_name = 10, RULE_gravity = 11, RULE_friction1 = 12, 
		RULE_friction2 = 13, RULE_xball = 14, RULE_yball = 15, RULE_xvelocity = 16, 
		RULE_yvelocity = 17, RULE_orientation = 18, RULE_x = 19, RULE_y = 20, 
		RULE_trigger = 21, RULE_action = 22, RULE_width = 23, RULE_height = 24;
	public static final String[] ruleNames = {
		"file", "board", "ball", "squareBumper", "circleBumper", "triangleBumper", 
		"rightFlipper", "leftFlipper", "absorber", "fire", "name", "gravity", 
		"friction1", "friction2", "xball", "yball", "xvelocity", "yvelocity", 
		"orientation", "x", "y", "trigger", "action", "width", "height"
	};

	@Override
	public String getGrammarFileName() { return "BoardMaker.g4"; }

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

	public BoardMakerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public TriangleBumperContext triangleBumper() {
			return getRuleContext(TriangleBumperContext.class,0);
		}
		public AbsorberContext absorber() {
			return getRuleContext(AbsorberContext.class,0);
		}
		public BallContext ball() {
			return getRuleContext(BallContext.class,0);
		}
		public SquareBumperContext squareBumper() {
			return getRuleContext(SquareBumperContext.class,0);
		}
		public FireContext fire(int i) {
			return getRuleContext(FireContext.class,i);
		}
		public RightFlipperContext rightFlipper() {
			return getRuleContext(RightFlipperContext.class,0);
		}
		public CircleBumperContext circleBumper() {
			return getRuleContext(CircleBumperContext.class,0);
		}
		public BoardContext board() {
			return getRuleContext(BoardContext.class,0);
		}
		public List<FireContext> fire() {
			return getRuleContexts(FireContext.class);
		}
		public LeftFlipperContext leftFlipper() {
			return getRuleContext(LeftFlipperContext.class,0);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			setState(65);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50); board();
				setState(51); ball();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(53); squareBumper();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(54); circleBumper();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(55); triangleBumper();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(56); rightFlipper();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(57); leftFlipper();
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(58); absorber();
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TRIGGERFIELD) {
					{
					{
					setState(59); fire();
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
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

	public static class BoardContext extends ParserRuleContext {
		public TerminalNode FRICTION2FIELD() { return getToken(BoardMakerParser.FRICTION2FIELD, 0); }
		public TerminalNode FRICTION1FIELD() { return getToken(BoardMakerParser.FRICTION1FIELD, 0); }
		public TerminalNode NAME() { return getToken(BoardMakerParser.NAME, 0); }
		public List<TerminalNode> FLOAT() { return getTokens(BoardMakerParser.FLOAT); }
		public TerminalNode NAMEFIELD() { return getToken(BoardMakerParser.NAMEFIELD, 0); }
		public TerminalNode GRAVITYFIELD() { return getToken(BoardMakerParser.GRAVITYFIELD, 0); }
		public TerminalNode FLOAT(int i) {
			return getToken(BoardMakerParser.FLOAT, i);
		}
		public BoardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_board; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterBoard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitBoard(this);
		}
	}

	public final BoardContext board() throws RecognitionException {
		BoardContext _localctx = new BoardContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_board);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67); match(NAMEFIELD);
			setState(68); match(NAME);
			setState(69); match(GRAVITYFIELD);
			setState(70); match(FLOAT);
			setState(71); match(FRICTION1FIELD);
			setState(72); match(FLOAT);
			setState(73); match(FRICTION2FIELD);
			setState(74); match(FLOAT);
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
		public TerminalNode XVELOCITYFIELD() { return getToken(BoardMakerParser.XVELOCITYFIELD, 0); }
		public TerminalNode NAME() { return getToken(BoardMakerParser.NAME, 0); }
		public List<TerminalNode> FLOAT() { return getTokens(BoardMakerParser.FLOAT); }
		public TerminalNode YVELOCITYFIELD() { return getToken(BoardMakerParser.YVELOCITYFIELD, 0); }
		public TerminalNode YFIELD() { return getToken(BoardMakerParser.YFIELD, 0); }
		public TerminalNode NAMEFIELD() { return getToken(BoardMakerParser.NAMEFIELD, 0); }
		public TerminalNode XFIELD() { return getToken(BoardMakerParser.XFIELD, 0); }
		public TerminalNode FLOAT(int i) {
			return getToken(BoardMakerParser.FLOAT, i);
		}
		public BallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ball; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterBall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitBall(this);
		}
	}

	public final BallContext ball() throws RecognitionException {
		BallContext _localctx = new BallContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ball);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); match(NAMEFIELD);
			setState(77); match(NAME);
			setState(78); match(XFIELD);
			setState(79); match(FLOAT);
			setState(80); match(YFIELD);
			setState(81); match(FLOAT);
			setState(82); match(XVELOCITYFIELD);
			setState(83); match(FLOAT);
			setState(84); match(YVELOCITYFIELD);
			setState(85); match(FLOAT);
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
		public List<TerminalNode> INTEGER() { return getTokens(BoardMakerParser.INTEGER); }
		public TerminalNode NAME() { return getToken(BoardMakerParser.NAME, 0); }
		public TerminalNode YFIELD() { return getToken(BoardMakerParser.YFIELD, 0); }
		public TerminalNode NAMEFIELD() { return getToken(BoardMakerParser.NAMEFIELD, 0); }
		public TerminalNode INTEGER(int i) {
			return getToken(BoardMakerParser.INTEGER, i);
		}
		public TerminalNode XFIELD() { return getToken(BoardMakerParser.XFIELD, 0); }
		public SquareBumperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squareBumper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterSquareBumper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitSquareBumper(this);
		}
	}

	public final SquareBumperContext squareBumper() throws RecognitionException {
		SquareBumperContext _localctx = new SquareBumperContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_squareBumper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87); match(NAMEFIELD);
			setState(88); match(NAME);
			setState(89); match(XFIELD);
			setState(90); match(INTEGER);
			setState(91); match(YFIELD);
			setState(92); match(INTEGER);
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
		public List<TerminalNode> INTEGER() { return getTokens(BoardMakerParser.INTEGER); }
		public TerminalNode NAME() { return getToken(BoardMakerParser.NAME, 0); }
		public TerminalNode YFIELD() { return getToken(BoardMakerParser.YFIELD, 0); }
		public TerminalNode NAMEFIELD() { return getToken(BoardMakerParser.NAMEFIELD, 0); }
		public TerminalNode INTEGER(int i) {
			return getToken(BoardMakerParser.INTEGER, i);
		}
		public TerminalNode XFIELD() { return getToken(BoardMakerParser.XFIELD, 0); }
		public CircleBumperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_circleBumper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterCircleBumper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitCircleBumper(this);
		}
	}

	public final CircleBumperContext circleBumper() throws RecognitionException {
		CircleBumperContext _localctx = new CircleBumperContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_circleBumper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94); match(NAMEFIELD);
			setState(95); match(NAME);
			setState(96); match(XFIELD);
			setState(97); match(INTEGER);
			setState(98); match(YFIELD);
			setState(99); match(INTEGER);
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
		public List<TerminalNode> INTEGER() { return getTokens(BoardMakerParser.INTEGER); }
		public TerminalNode NAME() { return getToken(BoardMakerParser.NAME, 0); }
		public TerminalNode ORIENTATIONFIELD() { return getToken(BoardMakerParser.ORIENTATIONFIELD, 0); }
		public TerminalNode YFIELD() { return getToken(BoardMakerParser.YFIELD, 0); }
		public TerminalNode NAMEFIELD() { return getToken(BoardMakerParser.NAMEFIELD, 0); }
		public TerminalNode INTEGER(int i) {
			return getToken(BoardMakerParser.INTEGER, i);
		}
		public TerminalNode XFIELD() { return getToken(BoardMakerParser.XFIELD, 0); }
		public TriangleBumperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triangleBumper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterTriangleBumper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitTriangleBumper(this);
		}
	}

	public final TriangleBumperContext triangleBumper() throws RecognitionException {
		TriangleBumperContext _localctx = new TriangleBumperContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_triangleBumper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); match(NAMEFIELD);
			setState(102); match(NAME);
			setState(103); match(XFIELD);
			setState(104); match(INTEGER);
			setState(105); match(YFIELD);
			setState(106); match(INTEGER);
			setState(107); match(ORIENTATIONFIELD);
			setState(108); match(INTEGER);
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
		public List<TerminalNode> INTEGER() { return getTokens(BoardMakerParser.INTEGER); }
		public TerminalNode NAME() { return getToken(BoardMakerParser.NAME, 0); }
		public TerminalNode ORIENTATIONFIELD() { return getToken(BoardMakerParser.ORIENTATIONFIELD, 0); }
		public TerminalNode YFIELD() { return getToken(BoardMakerParser.YFIELD, 0); }
		public TerminalNode NAMEFIELD() { return getToken(BoardMakerParser.NAMEFIELD, 0); }
		public TerminalNode INTEGER(int i) {
			return getToken(BoardMakerParser.INTEGER, i);
		}
		public TerminalNode XFIELD() { return getToken(BoardMakerParser.XFIELD, 0); }
		public RightFlipperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightFlipper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterRightFlipper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitRightFlipper(this);
		}
	}

	public final RightFlipperContext rightFlipper() throws RecognitionException {
		RightFlipperContext _localctx = new RightFlipperContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rightFlipper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110); match(NAMEFIELD);
			setState(111); match(NAME);
			setState(112); match(XFIELD);
			setState(113); match(INTEGER);
			setState(114); match(YFIELD);
			setState(115); match(INTEGER);
			setState(116); match(ORIENTATIONFIELD);
			setState(117); match(INTEGER);
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
		public List<TerminalNode> INTEGER() { return getTokens(BoardMakerParser.INTEGER); }
		public TerminalNode NAME() { return getToken(BoardMakerParser.NAME, 0); }
		public TerminalNode ORIENTATIONFIELD() { return getToken(BoardMakerParser.ORIENTATIONFIELD, 0); }
		public TerminalNode YFIELD() { return getToken(BoardMakerParser.YFIELD, 0); }
		public TerminalNode NAMEFIELD() { return getToken(BoardMakerParser.NAMEFIELD, 0); }
		public TerminalNode INTEGER(int i) {
			return getToken(BoardMakerParser.INTEGER, i);
		}
		public TerminalNode XFIELD() { return getToken(BoardMakerParser.XFIELD, 0); }
		public LeftFlipperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftFlipper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterLeftFlipper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitLeftFlipper(this);
		}
	}

	public final LeftFlipperContext leftFlipper() throws RecognitionException {
		LeftFlipperContext _localctx = new LeftFlipperContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_leftFlipper);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119); match(NAMEFIELD);
			setState(120); match(NAME);
			setState(121); match(XFIELD);
			setState(122); match(INTEGER);
			setState(123); match(YFIELD);
			setState(124); match(INTEGER);
			setState(125); match(ORIENTATIONFIELD);
			setState(126); match(INTEGER);
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
		public List<TerminalNode> INTEGER() { return getTokens(BoardMakerParser.INTEGER); }
		public TerminalNode NAME() { return getToken(BoardMakerParser.NAME, 0); }
		public TerminalNode WIDTHFIELD() { return getToken(BoardMakerParser.WIDTHFIELD, 0); }
		public TerminalNode YFIELD() { return getToken(BoardMakerParser.YFIELD, 0); }
		public TerminalNode NAMEFIELD() { return getToken(BoardMakerParser.NAMEFIELD, 0); }
		public TerminalNode HEIGHTFIELD() { return getToken(BoardMakerParser.HEIGHTFIELD, 0); }
		public TerminalNode INTEGER(int i) {
			return getToken(BoardMakerParser.INTEGER, i);
		}
		public TerminalNode XFIELD() { return getToken(BoardMakerParser.XFIELD, 0); }
		public AbsorberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_absorber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterAbsorber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitAbsorber(this);
		}
	}

	public final AbsorberContext absorber() throws RecognitionException {
		AbsorberContext _localctx = new AbsorberContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_absorber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128); match(NAMEFIELD);
			setState(129); match(NAME);
			setState(130); match(XFIELD);
			setState(131); match(INTEGER);
			setState(132); match(YFIELD);
			setState(133); match(INTEGER);
			setState(134); match(WIDTHFIELD);
			setState(135); match(INTEGER);
			setState(136); match(HEIGHTFIELD);
			setState(137); match(INTEGER);
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
		public TerminalNode ACTIONFIELD() { return getToken(BoardMakerParser.ACTIONFIELD, 0); }
		public List<TerminalNode> NAME() { return getTokens(BoardMakerParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(BoardMakerParser.NAME, i);
		}
		public TerminalNode TRIGGERFIELD() { return getToken(BoardMakerParser.TRIGGERFIELD, 0); }
		public FireContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fire; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterFire(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitFire(this);
		}
	}

	public final FireContext fire() throws RecognitionException {
		FireContext _localctx = new FireContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_fire);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139); match(TRIGGERFIELD);
			setState(140); match(NAME);
			setState(141); match(ACTIONFIELD);
			setState(142); match(NAME);
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

	public static class NameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(BoardMakerParser.NAME, 0); }
		public TerminalNode NAMEFIELD() { return getToken(BoardMakerParser.NAMEFIELD, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144); match(NAMEFIELD);
			setState(145); match(NAME);
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

	public static class GravityContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(BoardMakerParser.FLOAT, 0); }
		public TerminalNode GRAVITYFIELD() { return getToken(BoardMakerParser.GRAVITYFIELD, 0); }
		public GravityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gravity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterGravity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitGravity(this);
		}
	}

	public final GravityContext gravity() throws RecognitionException {
		GravityContext _localctx = new GravityContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_gravity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147); match(GRAVITYFIELD);
			setState(148); match(FLOAT);
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

	public static class Friction1Context extends ParserRuleContext {
		public TerminalNode FRICTION1FIELD() { return getToken(BoardMakerParser.FRICTION1FIELD, 0); }
		public TerminalNode FLOAT() { return getToken(BoardMakerParser.FLOAT, 0); }
		public Friction1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_friction1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterFriction1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitFriction1(this);
		}
	}

	public final Friction1Context friction1() throws RecognitionException {
		Friction1Context _localctx = new Friction1Context(_ctx, getState());
		enterRule(_localctx, 24, RULE_friction1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150); match(FRICTION1FIELD);
			setState(151); match(FLOAT);
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

	public static class Friction2Context extends ParserRuleContext {
		public TerminalNode FRICTION2FIELD() { return getToken(BoardMakerParser.FRICTION2FIELD, 0); }
		public TerminalNode FLOAT() { return getToken(BoardMakerParser.FLOAT, 0); }
		public Friction2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_friction2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterFriction2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitFriction2(this);
		}
	}

	public final Friction2Context friction2() throws RecognitionException {
		Friction2Context _localctx = new Friction2Context(_ctx, getState());
		enterRule(_localctx, 26, RULE_friction2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153); match(FRICTION2FIELD);
			setState(154); match(FLOAT);
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

	public static class XballContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(BoardMakerParser.FLOAT, 0); }
		public TerminalNode XFIELD() { return getToken(BoardMakerParser.XFIELD, 0); }
		public XballContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xball; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterXball(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitXball(this);
		}
	}

	public final XballContext xball() throws RecognitionException {
		XballContext _localctx = new XballContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_xball);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156); match(XFIELD);
			setState(157); match(FLOAT);
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

	public static class YballContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(BoardMakerParser.FLOAT, 0); }
		public TerminalNode YFIELD() { return getToken(BoardMakerParser.YFIELD, 0); }
		public YballContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yball; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterYball(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitYball(this);
		}
	}

	public final YballContext yball() throws RecognitionException {
		YballContext _localctx = new YballContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_yball);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159); match(YFIELD);
			setState(160); match(FLOAT);
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

	public static class XvelocityContext extends ParserRuleContext {
		public TerminalNode XVELOCITYFIELD() { return getToken(BoardMakerParser.XVELOCITYFIELD, 0); }
		public TerminalNode FLOAT() { return getToken(BoardMakerParser.FLOAT, 0); }
		public XvelocityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xvelocity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterXvelocity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitXvelocity(this);
		}
	}

	public final XvelocityContext xvelocity() throws RecognitionException {
		XvelocityContext _localctx = new XvelocityContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_xvelocity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); match(XVELOCITYFIELD);
			setState(163); match(FLOAT);
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

	public static class YvelocityContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(BoardMakerParser.FLOAT, 0); }
		public TerminalNode YVELOCITYFIELD() { return getToken(BoardMakerParser.YVELOCITYFIELD, 0); }
		public YvelocityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yvelocity; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterYvelocity(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitYvelocity(this);
		}
	}

	public final YvelocityContext yvelocity() throws RecognitionException {
		YvelocityContext _localctx = new YvelocityContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_yvelocity);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165); match(YVELOCITYFIELD);
			setState(166); match(FLOAT);
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

	public static class OrientationContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(BoardMakerParser.INTEGER, 0); }
		public TerminalNode ORIENTATIONFIELD() { return getToken(BoardMakerParser.ORIENTATIONFIELD, 0); }
		public OrientationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orientation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterOrientation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitOrientation(this);
		}
	}

	public final OrientationContext orientation() throws RecognitionException {
		OrientationContext _localctx = new OrientationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_orientation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168); match(ORIENTATIONFIELD);
			setState(169); match(INTEGER);
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

	public static class XContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(BoardMakerParser.INTEGER, 0); }
		public TerminalNode XFIELD() { return getToken(BoardMakerParser.XFIELD, 0); }
		public XContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_x; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterX(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitX(this);
		}
	}

	public final XContext x() throws RecognitionException {
		XContext _localctx = new XContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_x);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171); match(XFIELD);
			setState(172); match(INTEGER);
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

	public static class YContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(BoardMakerParser.INTEGER, 0); }
		public TerminalNode YFIELD() { return getToken(BoardMakerParser.YFIELD, 0); }
		public YContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_y; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterY(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitY(this);
		}
	}

	public final YContext y() throws RecognitionException {
		YContext _localctx = new YContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_y);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); match(YFIELD);
			setState(175); match(INTEGER);
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

	public static class TriggerContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(BoardMakerParser.NAME, 0); }
		public TerminalNode TRIGGERFIELD() { return getToken(BoardMakerParser.TRIGGERFIELD, 0); }
		public TriggerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trigger; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterTrigger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitTrigger(this);
		}
	}

	public final TriggerContext trigger() throws RecognitionException {
		TriggerContext _localctx = new TriggerContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_trigger);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177); match(TRIGGERFIELD);
			setState(178); match(NAME);
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

	public static class ActionContext extends ParserRuleContext {
		public TerminalNode ACTIONFIELD() { return getToken(BoardMakerParser.ACTIONFIELD, 0); }
		public TerminalNode NAME() { return getToken(BoardMakerParser.NAME, 0); }
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitAction(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180); match(ACTIONFIELD);
			setState(181); match(NAME);
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

	public static class WidthContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(BoardMakerParser.INTEGER, 0); }
		public TerminalNode WIDTHFIELD() { return getToken(BoardMakerParser.WIDTHFIELD, 0); }
		public WidthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_width; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterWidth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitWidth(this);
		}
	}

	public final WidthContext width() throws RecognitionException {
		WidthContext _localctx = new WidthContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_width);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183); match(WIDTHFIELD);
			setState(184); match(INTEGER);
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

	public static class HeightContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(BoardMakerParser.INTEGER, 0); }
		public TerminalNode HEIGHTFIELD() { return getToken(BoardMakerParser.HEIGHTFIELD, 0); }
		public HeightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_height; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).enterHeight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BoardMakerListener ) ((BoardMakerListener)listener).exitHeight(this);
		}
	}

	public final HeightContext height() throws RecognitionException {
		HeightContext _localctx = new HeightContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_height);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186); match(HEIGHTFIELD);
			setState(187); match(INTEGER);
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
		"\2\3\24\u00c0\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t"+
		"\27\4\30\t\30\4\31\t\31\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\7\2?\n\2\f\2\16\2B\13\2\5\2D\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\2\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\2\2\u00ae\2C\3\2\2\2\4E\3\2\2\2\6N\3\2\2\2\bY\3\2\2\2\n`\3\2\2\2\f"+
		"g\3\2\2\2\16p\3\2\2\2\20y\3\2\2\2\22\u0082\3\2\2\2\24\u008d\3\2\2\2\26"+
		"\u0092\3\2\2\2\30\u0095\3\2\2\2\32\u0098\3\2\2\2\34\u009b\3\2\2\2\36\u009e"+
		"\3\2\2\2 \u00a1\3\2\2\2\"\u00a4\3\2\2\2$\u00a7\3\2\2\2&\u00aa\3\2\2\2"+
		"(\u00ad\3\2\2\2*\u00b0\3\2\2\2,\u00b3\3\2\2\2.\u00b6\3\2\2\2\60\u00b9"+
		"\3\2\2\2\62\u00bc\3\2\2\2\64\65\5\4\3\2\65\66\5\6\4\2\66D\3\2\2\2\67D"+
		"\5\b\5\28D\5\n\6\29D\5\f\7\2:D\5\16\b\2;D\5\20\t\2<D\5\22\n\2=?\5\24\13"+
		"\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AD\3\2\2\2B@\3\2\2\2C\64\3\2"+
		"\2\2C\67\3\2\2\2C8\3\2\2\2C9\3\2\2\2C:\3\2\2\2C;\3\2\2\2C<\3\2\2\2C@\3"+
		"\2\2\2D\3\3\2\2\2EF\7\6\2\2FG\7\5\2\2GH\7\7\2\2HI\7\4\2\2IJ\7\17\2\2J"+
		"K\7\4\2\2KL\7\20\2\2LM\7\4\2\2M\5\3\2\2\2NO\7\6\2\2OP\7\5\2\2PQ\7\b\2"+
		"\2QR\7\4\2\2RS\7\t\2\2ST\7\4\2\2TU\7\n\2\2UV\7\4\2\2VW\7\13\2\2WX\7\4"+
		"\2\2X\7\3\2\2\2YZ\7\6\2\2Z[\7\5\2\2[\\\7\b\2\2\\]\7\3\2\2]^\7\t\2\2^_"+
		"\7\3\2\2_\t\3\2\2\2`a\7\6\2\2ab\7\5\2\2bc\7\b\2\2cd\7\3\2\2de\7\t\2\2"+
		"ef\7\3\2\2f\13\3\2\2\2gh\7\6\2\2hi\7\5\2\2ij\7\b\2\2jk\7\3\2\2kl\7\t\2"+
		"\2lm\7\3\2\2mn\7\f\2\2no\7\3\2\2o\r\3\2\2\2pq\7\6\2\2qr\7\5\2\2rs\7\b"+
		"\2\2st\7\3\2\2tu\7\t\2\2uv\7\3\2\2vw\7\f\2\2wx\7\3\2\2x\17\3\2\2\2yz\7"+
		"\6\2\2z{\7\5\2\2{|\7\b\2\2|}\7\3\2\2}~\7\t\2\2~\177\7\3\2\2\177\u0080"+
		"\7\f\2\2\u0080\u0081\7\3\2\2\u0081\21\3\2\2\2\u0082\u0083\7\6\2\2\u0083"+
		"\u0084\7\5\2\2\u0084\u0085\7\b\2\2\u0085\u0086\7\3\2\2\u0086\u0087\7\t"+
		"\2\2\u0087\u0088\7\3\2\2\u0088\u0089\7\21\2\2\u0089\u008a\7\3\2\2\u008a"+
		"\u008b\7\22\2\2\u008b\u008c\7\3\2\2\u008c\23\3\2\2\2\u008d\u008e\7\r\2"+
		"\2\u008e\u008f\7\5\2\2\u008f\u0090\7\16\2\2\u0090\u0091\7\5\2\2\u0091"+
		"\25\3\2\2\2\u0092\u0093\7\6\2\2\u0093\u0094\7\5\2\2\u0094\27\3\2\2\2\u0095"+
		"\u0096\7\7\2\2\u0096\u0097\7\4\2\2\u0097\31\3\2\2\2\u0098\u0099\7\17\2"+
		"\2\u0099\u009a\7\4\2\2\u009a\33\3\2\2\2\u009b\u009c\7\20\2\2\u009c\u009d"+
		"\7\4\2\2\u009d\35\3\2\2\2\u009e\u009f\7\b\2\2\u009f\u00a0\7\4\2\2\u00a0"+
		"\37\3\2\2\2\u00a1\u00a2\7\t\2\2\u00a2\u00a3\7\4\2\2\u00a3!\3\2\2\2\u00a4"+
		"\u00a5\7\n\2\2\u00a5\u00a6\7\4\2\2\u00a6#\3\2\2\2\u00a7\u00a8\7\13\2\2"+
		"\u00a8\u00a9\7\4\2\2\u00a9%\3\2\2\2\u00aa\u00ab\7\f\2\2\u00ab\u00ac\7"+
		"\3\2\2\u00ac\'\3\2\2\2\u00ad\u00ae\7\b\2\2\u00ae\u00af\7\3\2\2\u00af)"+
		"\3\2\2\2\u00b0\u00b1\7\t\2\2\u00b1\u00b2\7\3\2\2\u00b2+\3\2\2\2\u00b3"+
		"\u00b4\7\r\2\2\u00b4\u00b5\7\5\2\2\u00b5-\3\2\2\2\u00b6\u00b7\7\16\2\2"+
		"\u00b7\u00b8\7\5\2\2\u00b8/\3\2\2\2\u00b9\u00ba\7\21\2\2\u00ba\u00bb\7"+
		"\3\2\2\u00bb\61\3\2\2\2\u00bc\u00bd\7\22\2\2\u00bd\u00be\7\3\2\2\u00be"+
		"\63\3\2\2\2\4@C";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}