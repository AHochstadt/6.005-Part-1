grammar BoardMaker;

//Collaboration Statement: Used code from recitation as a basis for this grammar 

// This puts a Java package statement at the top of the output Java files.
@header {
}

// This adds code to the generated lexer and parser.
@members {
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
}

/*
 * These are the lexical rules. They define the tokens used by the lexer.
 * *** ANTLR requires tokens to be CAPITALIZED, like START_ITALIC, END_ITALIC, and TEXT.
 */


WHITESPACE : [ \t\r\n]+ -> skip ;
COMMENT : '#' ~('\n'|'\r')* '\r'? '\n'-> skip;

NAMEFIELD: ('name'' '*'=');
GRAVITYFIELD: ('gravity'' '*'=');
XFIELD: ('x'' '*'=');
YFIELD: ('y'' '*'=');
XVELOCITYFIELD: ('xVelocity'' '*'=');
YVELOCITYFIELD: ('yVelocity'' '*'=');
ORIENTATIONFIELD: ('orientation'' '*'=');
TRIGGERFIELD: ('trigger'' '*'=');
ACTIONFIELD: ('action'' '*'=');
FRICTION1FIELD: ('friction1'' '*'=');
FRICTION2FIELD: ('friction2'' '*'=');
WIDTHFIELD: ('width'' '*'=');
HEIGHTFIELD: ('height'' '*'=');
SQUAREBUMPERLABLE: 'squareBumper';
CIRCLEBUMPERLABLE: 'circleBumper';
TRIANGLEBUMPERLABLE: 'triangleBumper';
BOARDLABLE: 'board';
BALLLABLE: 'ball';
RIGHTFLIPPERLABLE: 'rightFlipper';
LEFTFLIPPERLABLE: 'leftFlipper';
ABSORBERLABLE: 'absorber';
FIRELABLE: 'fire';

INTEGER : [0-9]+;
FLOAT : '-'?([0-9]+'.'[0-9]*|'.'?[0-9]+);
NAME :[A-Za-z_][A-Za-z_0-9]*;






/*
 * These are the parser rules. They define the structures used by the parser.
 * *** ANTLR requires grammar nonterminals to be lowercase, like html, normal, and italic.
 */
 file: board  (ball|squareBumper|circleBumper|triangleBumper|rightFlipper|leftFlipper|absorber|fire)* EOF; 
board: BOARDLABLE name gravity? friction1? friction2?;
ball: BALLLABLE name xball yball xvelocity yvelocity;
squareBumper: SQUAREBUMPERLABLE name x y;
circleBumper: CIRCLEBUMPERLABLE name x y;
triangleBumper: TRIANGLEBUMPERLABLE name x y orientation;
rightFlipper: RIGHTFLIPPERLABLE name x y orientation;
leftFlipper: LEFTFLIPPERLABLE name x y orientation;
absorber: ABSORBERLABLE name x y width height;
fire: FIRELABLE trigger action;
name: NAMEFIELD NAME;
gravity: GRAVITYFIELD FLOAT;
friction1: FRICTION1FIELD FLOAT;
friction2: FRICTION2FIELD FLOAT;
xball: XFIELD FLOAT;
yball: YFIELD FLOAT;
xvelocity: XVELOCITYFIELD FLOAT;
yvelocity: YVELOCITYFIELD FLOAT;
orientation: ORIENTATIONFIELD INTEGER;
x: XFIELD INTEGER;
y: YFIELD INTEGER;
trigger: TRIGGERFIELD NAME;
action: ACTIONFIELD NAME;
width: WIDTHFIELD INTEGER;
height: HEIGHTFIELD INTEGER;



