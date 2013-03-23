package lite.ast;

import java.lang.StringBuffer;

public class LogicalAndNode extends BinaryOperatorNode
{
	public LogicalAndNode(ExpressionNode e1, ExpressionNode e2, int line, int col)
    {
		super(e1, e2, line, col);
	}

	public String unparse(int indent)
    {
        return this.unparseBinaryOperator("&&", indent);
	}
} // class LogicalAndNode 

