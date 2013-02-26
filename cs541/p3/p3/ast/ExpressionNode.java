package p3.ast;

// abstract superclass; only subclasses are actually created
abstract class ExpressionNode extends ASTNode
{
	ExpressionNode()
    {
		super();
	}

	ExpressionNode(int l, int c)
    {
		super(l, c);
	}

	static NullExpressionNode NULL = new NullExpressionNode();
}
