package p3.ast;

class NullArgumentsNode extends ArgumentsNode
{
	NullArgumentsNode()
    {
		// empty constructor
	}

	boolean isNull()
    {
        return true;
    }

	void unparse(int indent)
    {
        // Empty.
    }
} // class NullArgumentsNode 


