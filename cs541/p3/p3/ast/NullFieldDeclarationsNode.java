package p3.ast;

class NullFieldDeclarationsNode extends FieldDeclarationsNode
{
    NullFieldDeclarationsNode()
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
} // class nullFieldDeclsNode
