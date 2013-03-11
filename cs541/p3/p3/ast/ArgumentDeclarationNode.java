package p3.ast;

public class ArgumentDeclarationNode extends ASTNode
{
    private final IdentifierNode argName;
    private final TypeNode elementType;
    private final boolean isArray;

    public ArgumentDeclarationNode(IdentifierNode id,
            TypeNode t, boolean isArray, int line, int col)
    {
        super(line, col);
        this.argName = id;
        this.elementType = t;
        this.isArray = isArray;
    }
} // class ArrayArgumentDeclarationNode
