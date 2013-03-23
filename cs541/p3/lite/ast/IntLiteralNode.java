package lite.ast;

import java.lang.StringBuffer;

public class IntLiteralNode extends ExpressionNode
{
    public final int intValue;

	public IntLiteralNode(int intValue, int line, int col)
    {
		super(line, col);
        this.intValue = intValue;
	}

	public String unparse(int indent)
    {
        return Integer.toString(this.intValue);
	}
} // class IntLiteralNode 

