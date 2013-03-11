package p3.ast;

public class ArrayDeclarationNode extends FieldDeclarationNode
{
	public ArrayDeclarationNode(IdentifierNode id,
            TypeNode t, IntegerLiteralNode lit, int line, int col)
    {
		super(line, col);
		arrayName = id;
		elementType = t;
		arraySize = lit;
	}

	public final IdentifierNode arrayName;
	public final TypeNode elementType;
	public final IntegerLiteralNode arraySize;
} // class ArrayDeclarationNode
