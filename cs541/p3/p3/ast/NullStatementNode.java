package p3.ast;

class NullStatementNode extends StatementNode
{
    NullStatementNode()
    {
        // Empty.
    }

    boolean isNull()
    {
        return true;
    }

    void Unparse(int indent)
    {
        // Empty.
    }
} // class NullStatementNode 


