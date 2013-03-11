package p3.ast;

public class WhileNode extends StatementNode
{
	public final ExpressionNode label;
	public final ExpressionNode condition;
	public final StatementNode loopBody;

	public WhileNode(ExpressionNode i,
            ExpressionNode e, StatementNode s, int line, int col)
    {
		super(line, col);
        label = i;
        condition = e;
        loopBody = s;
	}
} // class WhileNode 
