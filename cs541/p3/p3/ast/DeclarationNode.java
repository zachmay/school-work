package p3.ast;

/*
 * class DeclarationNode
 *
 * Abstract class. Not for direct instantiation.
 */
abstract class declNode extends ASTNode
{
	DeclarationNode()
    {
		super();
	}

	DeclarationNode(int l, int c)
    {
		super(l, c);
	}
} // class DeclarationNode
