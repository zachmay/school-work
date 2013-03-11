package p3.ast;

// abstract superclass; only subclasses are actually created
abstract public class ExpressionNode extends ASTNode
{
	public ExpressionNode()
    {
		super();
	}

	public ExpressionNode(int l, int c)
    {
		super(l, c);
	}
}
