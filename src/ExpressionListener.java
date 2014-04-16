// Generated from src/Expression.g4 by ANTLR 4.0

package expr;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface ExpressionListener extends ParseTreeListener {
	void enterTriangleBumper(ExpressionParser.TriangleBumperContext ctx);
	void exitTriangleBumper(ExpressionParser.TriangleBumperContext ctx);

	void enterAbsorber(ExpressionParser.AbsorberContext ctx);
	void exitAbsorber(ExpressionParser.AbsorberContext ctx);

	void enterBall(ExpressionParser.BallContext ctx);
	void exitBall(ExpressionParser.BallContext ctx);

	void enterSquareBumper(ExpressionParser.SquareBumperContext ctx);
	void exitSquareBumper(ExpressionParser.SquareBumperContext ctx);

	void enterRightFlipper(ExpressionParser.RightFlipperContext ctx);
	void exitRightFlipper(ExpressionParser.RightFlipperContext ctx);

	void enterCircleBumper(ExpressionParser.CircleBumperContext ctx);
	void exitCircleBumper(ExpressionParser.CircleBumperContext ctx);

	void enterBoard(ExpressionParser.BoardContext ctx);
	void exitBoard(ExpressionParser.BoardContext ctx);

	void enterFire(ExpressionParser.FireContext ctx);
	void exitFire(ExpressionParser.FireContext ctx);

	void enterLeftFlipper(ExpressionParser.LeftFlipperContext ctx);
	void exitLeftFlipper(ExpressionParser.LeftFlipperContext ctx);
}