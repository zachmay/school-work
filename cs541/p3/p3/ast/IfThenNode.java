package p3.ast;

class IfThenNode extends StatementNode
{
	private final ExpressionNode condition;
	private final StatementNode thenPart;
	private final StatementNode elsePart;

	IfThenNode(ExpressionNode e, StatementNode s1, StatementNode s2, int line, int col)
    {
		super(line, col);
		condition = e;
		thenPart = s1;
		elsePart = s2;
	}

	void unparse(int indent)
    {
        // TODO: Fix unparse for else clause.
		System.out.print(linenum + ":");
		genIndent(indent);
		System.out.print("if (");
		condition.Unparse(0);
		System.out.println(")");
		thenPart.Unparse(indent+1);
		// No else parts in CSX-lite
	}
} // class IfThenNode 
