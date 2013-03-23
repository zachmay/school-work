package lite.ast;

public class TrueNode extends ExpressionNode
{
	public TrueNode(int line, int col)
    {
		super(line, col);
	}

	public String unparse(int indent)
    {
        return "true";
	}
} // class TrueNode 

