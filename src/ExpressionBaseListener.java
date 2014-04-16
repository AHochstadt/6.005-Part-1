// Generated from Expression.g4 by ANTLR 4.0

package expr;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

public class ExpressionBaseListener implements ExpressionListener {
	@Override public void enterExpression(ExpressionParser.ExpressionContext ctx) { }
	@Override public void exitExpression(ExpressionParser.ExpressionContext ctx) { }

	@Override public void enterConjunction(ExpressionParser.ConjunctionContext ctx) { }
	@Override public void exitConjunction(ExpressionParser.ConjunctionContext ctx) { }

	@Override public void enterLiteral(ExpressionParser.LiteralContext ctx) { }
	@Override public void exitLiteral(ExpressionParser.LiteralContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}