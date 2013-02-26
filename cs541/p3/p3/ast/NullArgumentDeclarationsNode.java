package p3.ast;

class NullArgumentDeclarationsNode extends ArgumentDeclarationsNode
{
    NullArgumentDeclarationsNode()
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
} // class NullArgumentDeclarationsNode 
