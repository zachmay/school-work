package p3.ast;

class ArgumentDeclarationsNode extends ASTNode
{
	private ArgumentDeclarationNode thisDecl;
	private ArgumentDeclarationsNode moreDecls;

    ArgumentDeclarationsNode()
    {
        // Empty.
    }

    ArgumentDeclarationsNode(ArgumentDeclarationNode arg,
                             ArgumentDeclarationsNode args,
                             int line,
                             int col)
    {
        super(line, col);
        thisDecl = arg;
        moreDecls = args;
    }

    static NullArgumentDeclarationsNode NULL = new NullArgumentDeclarationsNode();
} // class ArgumentDeclarationsNode 
