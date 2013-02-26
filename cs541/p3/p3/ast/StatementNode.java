package p3.ast;

// abstract superclass; only subclasses are actually created
abstract class StatementNode extends ASTNode
{
    StatementNode()
    {
        super();
    }

    StatementNode(int l, int c)
    {
        super(l, c);
    }

    static NullStatementNode NULL = new NullStatementNode();
}

