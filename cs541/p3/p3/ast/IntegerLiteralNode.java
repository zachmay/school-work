package p3.ast;

class IntegerLiteralNode extends ExpressionNode
{
	private final int intval;

	IntegerLiteralNode(int val, int line, int col)
    {
		super(line, col);
		intval = val;
	}
} // class IntegerLiteralNode 

