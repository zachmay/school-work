package lite.ast;

import java.lang.StringBuffer;

public class LogicalNotNode extends ExpressionNode
{
    public final ExpressionNode expr;

	public LogicalNotNode(ExpressionNode expr, int line, int col)
    {
		super(line, col);
        this.expr = expr;
	}

	public String unparse(int indent)
    {
        return new StringBuffer("!")
                        .append(this.expr.unparse(indent))
                        .toString();
	}
} // class LogicalNotNode 

