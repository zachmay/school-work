package p3.ast;

public class ReturnNode extends StatementNode
{
	public final ExpressionNode returnVal;

	public ReturnNode(ExpressionNode e, int line, int col)
    {
		super(line, col);
		returnVal = e;
	}
} // class ReturnNode 

