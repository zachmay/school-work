package p3.ast;

class NullStatementsNode extends StatementsNode
{
    NullStatementsNode()
    {
        // Empty.
    }

    boolean isNull()
    {
        return true;
    }

    void unparse(int indent)
    {
        // Empty.
    }
} // class NullStatementsNode
