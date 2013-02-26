package p3.ast;

abstract class TypeNode extends ASTNode
{
    // abstract superclass; only subclasses are actually created
	TypeNode()
    {
		super();
	}

	TypeNode(int l, int c)
    {
		super(l, c);
	}

	static NullTypeNode NULL = new NullTypeNode();
} // class TypeNode
