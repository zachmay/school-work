package p3.ast;

public abstract class TypeNode extends ASTNode
{
    // abstract superclass; only subclasses are actually created
	public TypeNode()
    {
		super();
	}

	public TypeNode(int l, int c)
    {
		super(l, c);
	}
} // class TypeNode
