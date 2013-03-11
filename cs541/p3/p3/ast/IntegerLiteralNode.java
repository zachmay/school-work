package p3.ast;

public class IntegerLiteralNode extends ExpressionNode
{
	public final int intval;

	public IntegerLiteralNode(int val, int line, int col)
    {
		super(line, col);
		intval = val;
	}
} // class IntegerLiteralNode 

