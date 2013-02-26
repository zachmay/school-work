package p3.ast;

class AssignmentNode extends StatementNode
{
	private final NameNode target;
	private final ExpressionNode source;

	AssignmentNode(NameNode n, ExpressionNode e, int line, int col)
    {
		super(line, col);
		target = n;
		source = e;
	}

	void unparse(int indent)
    {
		System.out.print(linenum + ":");
		genIndent(indent);
		target.Unparse(0);
		System.out.print(" = ");
		source.Unparse(0);
		System.out.println(";");
	}
} // class AssignmentNode 




