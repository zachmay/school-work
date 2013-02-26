package p3.ast;

class MethodDeclarationsNode extends ASTNode
{
    private MethodDeclarationNode thisDecl;
    private MethodDeclarationsNode moreDecls;

    MethodDeclarationsNode()
    {
        super();
    }

    MethodDeclarationsNode(MethodDeclarationNode m,
                           MethodDeclarationsNode ms,
                           int line,
                           int col)
    {
        super(line, col);
        thisDecl = m;
        moreDecls = ms;
    }

    static NullMethodDeclarationsNode NULL = new NullMethodDeclarationsNode();
} // class MethodDeclarationsNode 
