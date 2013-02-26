package p3.ast;

class ArrayArgumentDeclarationNode extends ArgumentDeclarationNode
{
    private final IdentifierNode argName;
    private final TypeNode elementType;

    ArrayArgumentDeclarationNode(IdentifierNode id, TypeNode t, int line, int col)
    {
        super(line, col);
        argName = id;
        elementType = t;
    }
} // class ArrayArgumentDeclarationNode
