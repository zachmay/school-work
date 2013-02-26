package p3.ast;

class MethodDeclarationNode extends ASTNode
{
    MethodDeclarationNode(IdentifierNode id,
                          ArgumentDeclarationsNode a,
                          TypeNode t,
                          FieldDeclarationsNode f,
                          StatementsNode s,
                          int line,
                          int col)
    {
        super(line, col);
        name = id;
        args = a;
        returnType = t;
        decls = f;
        stmts = s;
    }
    private final IdentifierNode name;
    private final ArgumentDeclarationsNode args;
    private final TypeNode returnType;
    private final FieldDeclarationsNode decls;
    private final StatementsNode stmts;
} // class MethodDeclarationNode
