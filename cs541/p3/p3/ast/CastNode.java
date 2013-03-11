package p3.ast;

public class CastNode extends ExpressionNode
{
	public final ExpressionNode operand;
	public final TypeNode resultType;

	public CastNode(TypeNode t, ExpressionNode e, int line, int col)
    {
		super(line, col);
		operand = e;
		resultType = t;
	}
} // class CastNode 


