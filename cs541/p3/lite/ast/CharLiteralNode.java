package lite.ast;

import java.lang.StringBuffer;

public class CharLiteralNode extends ExpressionNode
{
    public final String charValue;

	public CharLiteralNode(String charValue, int line, int col)
    {
		super(line, col);
        this.charValue = charValue;
	}

	public String unparse(int indent)
    {
        return this.charValue;
	}
} // class CharLiteralNode 

