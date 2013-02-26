package p3.ast;

class NullTypeNode extends TypeNode
{
	NullTypeNode()
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
} // class NullTypeNode
