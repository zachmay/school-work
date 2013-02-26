class UnaryOperatorNode extends ExpressionNode
{
	private final ExpressionNode operand;
	private final int operatorCode; // Token code of the operator

	UnaryOperatorNode(int op, ExpressionNode e, int line, int col)
    {
		super(line, col);
		operand = e;
		operatorCode = op;
	}
} // class UnaryOperatorNode 

