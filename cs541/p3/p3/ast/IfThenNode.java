package p3.ast;

public class IfThenNode extends StatementNode
{
	public final ExpressionNode condition;
	public final StatementNode thenPart;
	public final StatementNode elsePart;

	public IfThenNode(ExpressionNode e, StatementNode s1, StatementNode s2, int line, int col)
    {
		super(line, col);
		condition = e;
		thenPart = s1;
		elsePart = s2;
	}

	public void unparse(int indent)
    {
        // TODO: Fix unparse for else clause.
		System.out.print(linenum + ":");
		genIndent(indent);
		System.out.print("if (");
		condition.unparse(0);
		System.out.println(")");
		thenPart.unparse(indent+1);
		// No else parts in CSX-lite
	}
} // class IfThenNode 
