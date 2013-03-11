package p3.ast;

public class CallNode extends StatementNode
{
	public final IdentifierNode methodName;
	public final ArgumentsNode args;

	public CallNode(IdentifierNode id, ArgumentsNode a, int line, int col)
    {
		super(line, col);
		methodName = id;
		args = a;
	}
} // class CallNode 

