package p3.ast;

class ContinueNode extends StatementNode
{
	private final IdentifierNode label;

	ContinueNode(IdentifierNode i, int line, int col)
    {
		super(line, col);
		label = i;
	}
} // class ContinueNode 

