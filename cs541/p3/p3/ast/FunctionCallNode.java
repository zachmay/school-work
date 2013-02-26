package p3.ast;

class FunctionCallNode extends ExpressionNode
{
	private final IdentifierNode methodName;
	private final ArgumentsNode methodArgs;

	FunctionCallNode(IdentifierNode id, ArgumentsNode a, int line, int col)
    {
		super(line, col);
		methodName = id;
		methodArgs = a;
	}
} // class FunctionCallNode 
