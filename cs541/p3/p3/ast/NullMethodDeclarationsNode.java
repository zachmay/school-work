package p3.ast;

class NullMethodDeclarationsNode extends MethodDeclarationsNode
{
    NullMethodDeclarationsNode()
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
} // class NullMethodDeclarationsNode 
