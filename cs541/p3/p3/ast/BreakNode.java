package p3.ast;

class BreakNode extends StatementNode
{
	private final IdentifierNode label;

	BreakNode(IdentifierNode i, int line, int col)
    {
		super(line, col);
		label = i;
	}
} // class BreakNode 

