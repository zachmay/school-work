package p3.ast;

class CastNode extends ExpressionNode
{
	private final ExpressionNode operand;
	private final TypeNode resultType;

	CastNode(TypeNode t, ExpressionNode e, int line, int col)
    {
		super(line, col);
		operand = e;
		resultType = t;
	}
} // class CastNode 


