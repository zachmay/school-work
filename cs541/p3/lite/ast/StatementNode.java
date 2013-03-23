package lite.ast;

// abstract superclass; only subclasses are actually created
public abstract class StatementNode extends ASTNode
{
    public StatementNode()
    {
        super();
    }

    public StatementNode(int l, int c)
    {
        super(l, c);
    }
}

