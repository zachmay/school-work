package lite.ast;

public class DivisionNode extends BinaryOperatorNode
{
	public DivisionNode(ExpressionNode e1, ExpressionNode e2, int line, int col)
    {
		super(e1, e2, line, col);
	}

	public String unparse(int indent)
    {
        return this.unparseBinaryOperator("/", indent);
	}
} // class DivisionNode

