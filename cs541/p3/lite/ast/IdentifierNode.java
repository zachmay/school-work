package lite.ast;

public class IdentifierNode extends ExpressionNode
{
	public final String identifierText;

	public IdentifierNode(String idName, int line, int col)
    {
		super(line, col);
		this.identifierText = idName;
	}

	public String unparse(int indent)
    {
        return this.identifierText;
	}
} // class IdentifierNode 

