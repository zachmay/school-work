package p3.ast;

public class IdentifierNode extends ExpressionNode
{
	public final String idname;

	public IdentifierNode(String identname, int line, int col)
    {
		super(line, col);
		idname = identname;
	}

	public void unparse(int indent)
    {
		System.out.print(idname);
	}
} // class IdentifierNode 

