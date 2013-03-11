package p3.ast;

public class AssignmentNode extends StatementNode
{
	public final NameNode target;
	public final ExpressionNode source;

	public AssignmentNode(NameNode n, ExpressionNode e, int line, int col)
    {
		super(line, col);
		target = n;
		source = e;
	}

	public void unparse(int indent)
    {
		System.out.print(linenum + ":");
		genIndent(indent);
		target.unparse(0);
		System.out.print(" = ");
		source.unparse(0);
		System.out.println(";");
	}
} // class AssignmentNode 




