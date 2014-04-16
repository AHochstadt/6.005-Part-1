// Generated from Expression.g4 by ANTLR 4.0

package expr;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface ExpressionListener extends ParseTreeListener {
	void enterExpression(ExpressionParser.ExpressionContext ctx);
	void exitExpression(ExpressionParser.ExpressionContext ctx);

	void enterConjunction(ExpressionParser.ConjunctionContext ctx);
	void exitConjunction(ExpressionParser.ConjunctionContext ctx);

	void enterLiteral(ExpressionParser.LiteralContext ctx);
	void exitLiteral(ExpressionParser.LiteralContext ctx);
}