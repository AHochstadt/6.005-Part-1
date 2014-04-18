// Generated from BoardMaker.g4 by ANTLR 4.0


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
		WHITESPACE=1, COMMENT=2, NAMEFIELD=3, GRAVITYFIELD=4, XFIELD=5, YFIELD=6, 
		XVELOCITYFIELD=7, YVELOCITYFIELD=8, ORIENTATIONFIELD=9, TRIGGERFIELD=10, 
		ACTIONFIELD=11, FRICTION1FIELD=12, FRICTION2FIELD=13, WIDTHFIELD=14, HEIGHTFIELD=15, 
		SQUAREBUMPERLABLE=16, CIRCLEBUMPERLABLE=17, TRIANGLEBUMPERLABLE=18, BOARDLABLE=19, 
		BALLLABLE=20, RIGHTFLIPPERLABLE=21, LEFTFLIPPERLABLE=22, ABSORBERLABLE=23, 
		FIRELABLE=24, INTEGER=25, FLOAT=26, NAME=27;
	public static final String[] tokenNames = {
		"<INVALID>", "WHITESPACE", "COMMENT", "NAMEFIELD", "GRAVITYFIELD", "XFIELD", 
		"YFIELD", "XVELOCITYFIELD", "YVELOCITYFIELD", "ORIENTATIONFIELD", "TRIGGERFIELD", 
		"ACTIONFIELD", "FRICTION1FIELD", "FRICTION2FIELD", "WIDTHFIELD", "HEIGHTFIELD", 
		"'squareBumper'", "'circleBumper'", "'triangleBumper'", "'board'", "'ball'", 
		"'rightFlipper'", "'leftFlipper'", "'absorber'", "'fire'", "INTEGER", 
		"FLOAT", "NAME"
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
		public SquareBumperContext squareBumper(int i) {
			return getRuleContext(SquareBumperContext.class,i);
		}
		public CircleBumperContext circleBumper(int i) {
			return getRuleContext(CircleBumperContext.class,i);
		}
		public List<TriangleBumperContext> triangleBumper() {
			return getRuleContexts(TriangleBumperContext.class);
		}
		public List<AbsorberContext> absorber() {
			return getRuleContexts(AbsorberContext.class);
		}
		public List<BallContext> ball() {
			return getRuleContexts(BallContext.class);
		}
		public AbsorberContext absorber(int i) {
			return getRuleContext(AbsorberContext.class,i);
		}
		public List<SquareBumperContext> squareBumper() {
			return getRuleContexts(SquareBumperContext.class);
		}
		public List<CircleBumperContext> circleBumper() {
			return getRuleContexts(CircleBumperContext.class);
		}
		public BoardContext board() {
			return getRuleContext(BoardContext.class,0);
		}
		public List<FireContext> fire() {
			return getRuleContexts(FireContext.class);
		}
		public TriangleBumperContext triangleBumper(int i) {
			return getRuleContext(TriangleBumperContext.class,i);
		}
		public LeftFlipperContext leftFlipper(int i) {
			return getRuleContext(LeftFlipperContext.class,i);
		}
		public FireContext fire(int i) {
			return getRuleContext(FireContext.class,i);
		}
		public TerminalNode EOF() { return getToken(BoardMakerParser.EOF, 0); }
		public List<RightFlipperContext> rightFlipper() {
			return getRuleContexts(RightFlipperContext.class);
		}
		public BallContext ball(int i) {
			return getRuleContext(BallContext.class,i);
		}
		public RightFlipperContext rightFlipper(int i) {
			return getRuleContext(RightFlipperContext.class,i);
		}
		public List<LeftFlipperContext> leftFlipper() {
			return getRuleContexts(LeftFlipperContext.class);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(50); board();
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SQUAREBUMPERLABLE) | (1L << CIRCLEBUMPERLABLE) | (1L << TRIANGLEBUMPERLABLE) | (1L << BALLLABLE) | (1L << RIGHTFLIPPERLABLE) | (1L << LEFTFLIPPERLABLE) | (1L << ABSORBERLABLE) | (1L << FIRELABLE))) != 0)) {
				{
				setState(59);
				switch (_input.LA(1)) {
				case BALLLABLE:
					{
					setState(51); ball();
					}
					break;
				case SQUAREBUMPERLABLE:
					{
					setState(52); squareBumper();
					}
					break;
				case CIRCLEBUMPERLABLE:
					{
					setState(53); circleBumper();
					}
					break;
				case TRIANGLEBUMPERLABLE:
					{
					setState(54); triangleBumper();
					}
					break;
				case RIGHTFLIPPERLABLE:
					{
					setState(55); rightFlipper();
					}
					break;
				case LEFTFLIPPERLABLE:
					{
					setState(56); leftFlipper();
					}
					break;
				case ABSORBERLABLE:
					{
					setState(57); absorber();
					}
					break;
				case FIRELABLE:
					{
					setState(58); fire();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64); match(EOF);
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
		public Friction1Context friction1() {
			return getRuleContext(Friction1Context.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode BOARDLABLE() { return getToken(BoardMakerParser.BOARDLABLE, 0); }
		public Friction2Context friction2() {
			return getRuleContext(Friction2Context.class,0);
		}
		public GravityContext gravity() {
			return getRuleContext(GravityContext.class,0);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); match(BOARDLABLE);
			setState(67); name();
			setState(69);
			_la = _input.LA(1);
			if (_la==GRAVITYFIELD) {
				{
				setState(68); gravity();
				}
			}

			setState(72);
			_la = _input.LA(1);
			if (_la==FRICTION1FIELD) {
				{
				setState(71); friction1();
				}
			}

			setState(75);
			_la = _input.LA(1);
			if (_la==FRICTION2FIELD) {
				{
				setState(74); friction2();
				}
			}

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
		public YballContext yball() {
			return getRuleContext(YballContext.class,0);
		}
		public TerminalNode BALLLABLE() { return getToken(BoardMakerParser.BALLLABLE, 0); }
		public YvelocityContext yvelocity() {
			return getRuleContext(YvelocityContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public XvelocityContext xvelocity() {
			return getRuleContext(XvelocityContext.class,0);
		}
		public XballContext xball() {
			return getRuleContext(XballContext.class,0);
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
			setState(77); match(BALLLABLE);
			setState(78); name();
			setState(79); xball();
			setState(80); yball();
			setState(81); xvelocity();
			setState(82); yvelocity();
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
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public YContext y() {
			return getRuleContext(YContext.class,0);
		}
		public XContext x() {
			return getRuleContext(XContext.class,0);
		}
		public TerminalNode SQUAREBUMPERLABLE() { return getToken(BoardMakerParser.SQUAREBUMPERLABLE, 0); }
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
			setState(84); match(SQUAREBUMPERLABLE);
			setState(85); name();
			setState(86); x();
			setState(87); y();
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
		public TerminalNode CIRCLEBUMPERLABLE() { return getToken(BoardMakerParser.CIRCLEBUMPERLABLE, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public YContext y() {
			return getRuleContext(YContext.class,0);
		}
		public XContext x() {
			return getRuleContext(XContext.class,0);
		}
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
			setState(89); match(CIRCLEBUMPERLABLE);
			setState(90); name();
			setState(91); x();
			setState(92); y();
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
		public OrientationContext orientation() {
			return getRuleContext(OrientationContext.class,0);
		}
		public TerminalNode TRIANGLEBUMPERLABLE() { return getToken(BoardMakerParser.TRIANGLEBUMPERLABLE, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public YContext y() {
			return getRuleContext(YContext.class,0);
		}
		public XContext x() {
			return getRuleContext(XContext.class,0);
		}
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
			setState(94); match(TRIANGLEBUMPERLABLE);
			setState(95); name();
			setState(96); x();
			setState(97); y();
			setState(98); orientation();
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
		public OrientationContext orientation() {
			return getRuleContext(OrientationContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode RIGHTFLIPPERLABLE() { return getToken(BoardMakerParser.RIGHTFLIPPERLABLE, 0); }
		public YContext y() {
			return getRuleContext(YContext.class,0);
		}
		public XContext x() {
			return getRuleContext(XContext.class,0);
		}
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
			setState(100); match(RIGHTFLIPPERLABLE);
			setState(101); name();
			setState(102); x();
			setState(103); y();
			setState(104); orientation();
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
		public OrientationContext orientation() {
			return getRuleContext(OrientationContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LEFTFLIPPERLABLE() { return getToken(BoardMakerParser.LEFTFLIPPERLABLE, 0); }
		public YContext y() {
			return getRuleContext(YContext.class,0);
		}
		public XContext x() {
			return getRuleContext(XContext.class,0);
		}
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
			setState(106); match(LEFTFLIPPERLABLE);
			setState(107); name();
			setState(108); x();
			setState(109); y();
			setState(110); orientation();
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
		public HeightContext height() {
			return getRuleContext(HeightContext.class,0);
		}
		public WidthContext width() {
			return getRuleContext(WidthContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode ABSORBERLABLE() { return getToken(BoardMakerParser.ABSORBERLABLE, 0); }
		public YContext y() {
			return getRuleContext(YContext.class,0);
		}
		public XContext x() {
			return getRuleContext(XContext.class,0);
		}
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
			setState(112); match(ABSORBERLABLE);
			setState(113); name();
			setState(114); x();
			setState(115); y();
			setState(116); width();
			setState(117); height();
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
		public TriggerContext trigger() {
			return getRuleContext(TriggerContext.class,0);
		}
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public TerminalNode FIRELABLE() { return getToken(BoardMakerParser.FIRELABLE, 0); }
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
			setState(119); match(FIRELABLE);
			setState(120); trigger();
			setState(121); action();
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
			setState(123); match(NAMEFIELD);
			setState(124); match(NAME);
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
			setState(126); match(GRAVITYFIELD);
			setState(127); match(FLOAT);
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
			setState(129); match(FRICTION1FIELD);
			setState(130); match(FLOAT);
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
			setState(132); match(FRICTION2FIELD);
			setState(133); match(FLOAT);
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
			setState(135); match(XFIELD);
			setState(136); match(FLOAT);
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
			setState(138); match(YFIELD);
			setState(139); match(FLOAT);
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
			setState(141); match(XVELOCITYFIELD);
			setState(142); match(FLOAT);
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
			setState(144); match(YVELOCITYFIELD);
			setState(145); match(FLOAT);
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
			setState(147); match(ORIENTATIONFIELD);
			setState(148); match(INTEGER);
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
			setState(150); match(XFIELD);
			setState(151); match(INTEGER);
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
			setState(153); match(YFIELD);
			setState(154); match(INTEGER);
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
			setState(156); match(TRIGGERFIELD);
			setState(157); match(NAME);
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
			setState(159); match(ACTIONFIELD);
			setState(160); match(NAME);
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
			setState(162); match(WIDTHFIELD);
			setState(163); match(INTEGER);
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
			setState(165); match(HEIGHTFIELD);
			setState(166); match(INTEGER);
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
		"\2\3\35\u00ab\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t"+
		"\27\4\30\t\30\4\31\t\31\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\7\2>\n\2\f\2\16\2A\13\2\3\2\3\2\3\3\3\3\3\3\5\3H\n\3\3\3\5\3K\n\3\3\3"+
		"\5\3N\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3"+
		"\32\2\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\2\u009c"+
		"\2\64\3\2\2\2\4D\3\2\2\2\6O\3\2\2\2\bV\3\2\2\2\n[\3\2\2\2\f`\3\2\2\2\16"+
		"f\3\2\2\2\20l\3\2\2\2\22r\3\2\2\2\24y\3\2\2\2\26}\3\2\2\2\30\u0080\3\2"+
		"\2\2\32\u0083\3\2\2\2\34\u0086\3\2\2\2\36\u0089\3\2\2\2 \u008c\3\2\2\2"+
		"\"\u008f\3\2\2\2$\u0092\3\2\2\2&\u0095\3\2\2\2(\u0098\3\2\2\2*\u009b\3"+
		"\2\2\2,\u009e\3\2\2\2.\u00a1\3\2\2\2\60\u00a4\3\2\2\2\62\u00a7\3\2\2\2"+
		"\64?\5\4\3\2\65>\5\6\4\2\66>\5\b\5\2\67>\5\n\6\28>\5\f\7\29>\5\16\b\2"+
		":>\5\20\t\2;>\5\22\n\2<>\5\24\13\2=\65\3\2\2\2=\66\3\2\2\2=\67\3\2\2\2"+
		"=8\3\2\2\2=9\3\2\2\2=:\3\2\2\2=;\3\2\2\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2"+
		"?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BC\7\1\2\2C\3\3\2\2\2DE\7\25\2\2EG\5\26"+
		"\f\2FH\5\30\r\2GF\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IK\5\32\16\2JI\3\2\2\2JK"+
		"\3\2\2\2KM\3\2\2\2LN\5\34\17\2ML\3\2\2\2MN\3\2\2\2N\5\3\2\2\2OP\7\26\2"+
		"\2PQ\5\26\f\2QR\5\36\20\2RS\5 \21\2ST\5\"\22\2TU\5$\23\2U\7\3\2\2\2VW"+
		"\7\22\2\2WX\5\26\f\2XY\5(\25\2YZ\5*\26\2Z\t\3\2\2\2[\\\7\23\2\2\\]\5\26"+
		"\f\2]^\5(\25\2^_\5*\26\2_\13\3\2\2\2`a\7\24\2\2ab\5\26\f\2bc\5(\25\2c"+
		"d\5*\26\2de\5&\24\2e\r\3\2\2\2fg\7\27\2\2gh\5\26\f\2hi\5(\25\2ij\5*\26"+
		"\2jk\5&\24\2k\17\3\2\2\2lm\7\30\2\2mn\5\26\f\2no\5(\25\2op\5*\26\2pq\5"+
		"&\24\2q\21\3\2\2\2rs\7\31\2\2st\5\26\f\2tu\5(\25\2uv\5*\26\2vw\5\60\31"+
		"\2wx\5\62\32\2x\23\3\2\2\2yz\7\32\2\2z{\5,\27\2{|\5.\30\2|\25\3\2\2\2"+
		"}~\7\5\2\2~\177\7\35\2\2\177\27\3\2\2\2\u0080\u0081\7\6\2\2\u0081\u0082"+
		"\7\34\2\2\u0082\31\3\2\2\2\u0083\u0084\7\16\2\2\u0084\u0085\7\34\2\2\u0085"+
		"\33\3\2\2\2\u0086\u0087\7\17\2\2\u0087\u0088\7\34\2\2\u0088\35\3\2\2\2"+
		"\u0089\u008a\7\7\2\2\u008a\u008b\7\34\2\2\u008b\37\3\2\2\2\u008c\u008d"+
		"\7\b\2\2\u008d\u008e\7\34\2\2\u008e!\3\2\2\2\u008f\u0090\7\t\2\2\u0090"+
		"\u0091\7\34\2\2\u0091#\3\2\2\2\u0092\u0093\7\n\2\2\u0093\u0094\7\34\2"+
		"\2\u0094%\3\2\2\2\u0095\u0096\7\13\2\2\u0096\u0097\7\33\2\2\u0097\'\3"+
		"\2\2\2\u0098\u0099\7\7\2\2\u0099\u009a\7\33\2\2\u009a)\3\2\2\2\u009b\u009c"+
		"\7\b\2\2\u009c\u009d\7\33\2\2\u009d+\3\2\2\2\u009e\u009f\7\f\2\2\u009f"+
		"\u00a0\7\35\2\2\u00a0-\3\2\2\2\u00a1\u00a2\7\r\2\2\u00a2\u00a3\7\35\2"+
		"\2\u00a3/\3\2\2\2\u00a4\u00a5\7\20\2\2\u00a5\u00a6\7\33\2\2\u00a6\61\3"+
		"\2\2\2\u00a7\u00a8\7\21\2\2\u00a8\u00a9\7\33\2\2\u00a9\63\3\2\2\2\7=?"+
		"GJM";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}