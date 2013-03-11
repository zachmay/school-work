package p3.ast;

public class ContinueNode extends StatementNode
{
	public final IdentifierNode label;

	public ContinueNode(IdentifierNode i, int line, int col)
    {
		super(line, col);
		label = i;
	}
} // class ContinueNode 

