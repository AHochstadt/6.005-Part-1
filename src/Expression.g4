grammar Expression;

// This puts a Java package statement at the top of the output Java files.
@header {
package expr;
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

INTEGER : [0-9]+;
FLOAT : '-'?([0-9]+'.'[0-9]*|'.'?[0-9]+);
NAME :[A-Za-z_][A-Za-z_0-9]*;

NAMEFIELD: 'name=';
GRAVITYFIELD: 'gravity=';
XFIELD: 'x=';
YFIELD: 'y=';
XVELOCITYFIELD: 'xvelocity=';
YVELOCITYFIELD: 'yvelocity=';
ORIENTATIONFIELD: 'orientation=';
TRIGGERFIELD: 'trigger=';
ACTIONFIELD: 'action=';
FRICTION1FIELD: 'friction1=';
FRICTION2FIELD: 'friction2=';
WIDTHFIELD: 'width=';
HEIGHTFIELD: 'height=';




/*
 * These are the parser rules. They define the structures used by the parser.
 * *** ANTLR requires grammar nonterminals to be lowercase, like html, normal, and italic.
 */
board: NAMEFIELD NAME GRAVITYFIELD FLOAT FRICTION1FIELD FLOAT FRICTION2FIELD FLOAT;
ball: NAMEFIELD NAME XFIELD FLOAT YFIELD FLOAT XVELOCITYFIELD FLOAT YVELOCITYFIELD FLOAT;
squareBumper: NAMEFIELD NAME XFIELD INTEGER YFIELD INTEGER;
circleBumper: NAMEFIELD NAME XFIELD INTEGER YFIELD INTEGER;
triangleBumper: NAMEFIELD NAME XFIELD INTEGER YFIELD INTEGER ORIENTATIONFIELD INTEGER;
rightFlipper: NAMEFIELD NAME XFIELD INTEGER YFIELD INTEGER ORIENTATIONFIELD INTEGER;
leftFlipper: NAMEFIELD NAME XFIELD INTEGER YFIELD INTEGER ORIENTATIONFIELD INTEGER;
absorber: NAMEFIELD NAME XFIELD INTEGER YFIELD INTEGER WIDTHFIELD INTEGER HEIGHTFIELD INTEGER;
fire: TRIGGERFIELD NAME ACTIONFIELD NAME;

COMMENT : '#' [ \t\r\n]+ -> skip;
WHITESPACE : [ \t\r\n]+ -> skip ;
