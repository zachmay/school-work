package p3.ast;

class CallNode extends StatementNode
{
	private final IdentifierNode methodName;
	private final ArgumentsNode args;

	CallNode(IdentifierNode id, ArgumentsNode a, int line, int col)
    {
		super(line, col);
		methodName = id;
		args = a;
	}
} // class CallNode 

