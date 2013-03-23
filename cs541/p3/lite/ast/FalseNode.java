package lite.ast;

public class FalseNode extends ExpressionNode
{
	public FalseNode(int line, int col)
    {
		super(line, col);
	}

	public String unparse(int indent)
    {
        return "false";
	}
} // class FalseNode 

