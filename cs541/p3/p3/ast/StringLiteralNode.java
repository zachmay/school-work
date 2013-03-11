package p3.ast;

public class StringLiteralNode extends ExpressionNode
{
	public final String strval;

	public StringLiteralNode(String stringval, int line, int col)
    {
		super(line, col);
		strval = stringval;
	}
} // class StringLiteralNode 
