package p3.ast;

class ReturnNode extends StatementNode
{
	private final ExpressionNode returnVal;

	ReturnNode(ExpressionNode e, int line, int col)
    {
		super(line, col);
		returnVal = e;
	}
} // class ReturnNode 

