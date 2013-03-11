package p3.ast;

class UnaryOperatorNode extends ExpressionNode
{
	public final ExpressionNode operand;
	public final int operatorCode; // Token code of the operator

	public UnaryOperatorNode(int op, ExpressionNode e, int line, int col)
    {
		super(line, col);
		operand = e;
		operatorCode = op;
	}
} // class UnaryOperatorNode 

