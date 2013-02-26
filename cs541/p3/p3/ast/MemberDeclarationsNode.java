package p3.ast;

class MemberDeclarationsNode extends ASTNode
{
    FieldDeclarationssNode fields;
    private final MethodDeclarationsNode methods;

    MemberDeclarationsNode(FieldDeclarationssNode f,
                           MethodDeclarationssNode m,
                           int line,
                           int col)
    {
        super(line, col);
        fields = f;
        methods = m;
    }
} // class memberDeclsNode
