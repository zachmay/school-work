package p3.ast;

class NullPrintNode extends PrintNode
{
	NullPrintNode()
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
} // class NullPrintNode 

