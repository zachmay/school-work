package lite.ast;

public class FieldDeclarationNode extends MemberDeclarationNode
{
    public final IdentifierNode id;

    public FieldDeclarationNode(IdentifierNode id, int line, int col)
    {
        super(line, col);
        this.id = id;
    }
} // class FieldDeclarationNode 

