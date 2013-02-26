package p3.ast;

class NullReadNode extends ReadNode
{
    NullReadNode()
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
} // class NullReadNode 

