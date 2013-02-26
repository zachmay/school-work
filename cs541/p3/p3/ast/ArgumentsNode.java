package p3.ast;

class ArgumentsNode extends ASTNode
{
	ArgumentsNode()
    {
        // Empty.
    }

	ArgumentsNode(ExpressionNode e, ArgumentsNode a, int line, int col)
    {
		super(line, col);
		argVal = e;
		moreArgs = a;
	}

	static NullArgumentsNode NULL = new NullArgumentsNode();
	private ExpressionNode argVal;
	private ArgumentsNode moreArgs;
} // class ArgumentsNode 

