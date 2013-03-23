package lite.ast;

import java.lang.StringBuffer;

public class StringLiteralNode extends ExpressionNode
{
    public final String stringValue;

	public StringLiteralNode(String stringValue, int line, int col)
    {
		super(line, col);
        this.stringValue = stringValue;
	}

	public String unparse(int indent)
    {
        return this.stringValue;
	}
} // class StringLiteralNode 

