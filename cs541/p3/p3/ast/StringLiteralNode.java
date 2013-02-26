package p3.ast;

class StringLiteralNode extends ExpressionNode
{
	private final String strval;

	StringLiteralNode(String stringval, int line, int col)
    {
		super(line, col);
		strval = stringval;
	}
} // class StringLiteralNode 
