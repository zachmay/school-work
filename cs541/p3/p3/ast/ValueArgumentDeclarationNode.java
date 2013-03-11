package p3.ast;

public class ValueArgumentDeclarationNode extends ArgumentDeclarationNode
{
	public final IdentifierNode argName;
	public final TypeNode argType;

	public ValueArgumentDeclarationNode(IdentifierNode id, TypeNode t, int line, int col)
    {
		super(line, col);
		argName = id;
		argType = t;
	}
} // class ValueArgumentDeclarationNode 

