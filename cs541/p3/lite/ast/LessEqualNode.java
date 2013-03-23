package lite.ast;

import java.lang.StringBuffer;

public class LessEqualNode extends BinaryOperatorNode
{
	public LessEqualNode(ExpressionNode e1, ExpressionNode e2, int line, int col)
    {
		super(e1, e2, line, col);
	}

	public String unparse(int indent)
    {
        return this.unparseBinaryOperator("<=", indent);
	}
} // class LessEqualNode 

