package p3.ast;

class ArrayDeclarationNode extends DeclarationNode
{
	ArrayDeclarationNode(IdentifierNode id, TypeNode t, IntegerLiteralNode lit, int line, int col)
    {
		super(line, col);
		arrayName = id;
		elementType = t;
		arraySize = lit;
	}

	private final IdentifierNode arrayName;
	private final TypeNode elementType;
	private final IntegerLiteralNode arraySize;
} // class ArrayDeclarationNode
