package p3.ast;

public class BreakNode extends StatementNode
{
	public final IdentifierNode label;

	public BreakNode(IdentifierNode i, int line, int col)
    {
		super(line, col);
		label = i;
	}
} // class BreakNode 

