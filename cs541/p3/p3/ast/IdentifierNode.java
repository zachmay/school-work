package p3.ast;

class IdentifierNode extends ExpressionNode
{
	private final String idname;

	IdentifierNode(String identname, int line, int col)
    {
		super(line, col);
		idname = identname;
	}

	void Unparse(int indent)
    {
		System.out.print(idname);
	}
} // class IdentifierNode 

