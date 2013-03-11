package p3.ast;

public class FunctionCallNode extends ExpressionNode
{
	public final IdentifierNode methodName;
	public final ArgumentsNode methodArgs;

	public FunctionCallNode(IdentifierNode id, ArgumentsNode a, int line, int col)
    {
		super(line, col);
		methodName = id;
		methodArgs = a;
	}
} // class FunctionCallNode 
