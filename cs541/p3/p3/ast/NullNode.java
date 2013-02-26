package p3.ast;

class NullNode extends ASTNode
{
    // This class definition probably doesn't need to be changed
	NullNode()
    {
		super();
	}

	boolean isNull()
    {
		return true;
	}

	void unparse(int indent)
    {
		// no action
	}
} // class nullNode

