package p3.ast;

class WhileNode extends StatementNode
{
	private final ExpressionNode label;
	private final ExpressionNode condition;
	private final StatementNode loopBody;

	WhileNode(ExpressionNode i, ExpressionNode e, StatementNode s, int line, int col)
    {
		super(line, col);
        label = i;
        condition = e;
        loopBody = s;
	}
} // class WhileNode 
