package p3.ast;

class ValueArgumentDeclarationNode extends ArgumentDeclarationNode
{
	private final IdentifierNode argName;
	private final TypeNode argType;

	ValueArgumentDeclarationNode(IdentifierNode id, TypeNode t, int line, int col)
    {
		super(line, col);
		argName = id;
		argType = t;
	}
} // class ValueArgumentDeclarationNode 

