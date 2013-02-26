package p3.ast;

class NullExpressionNode extends ExpressionNode
{
	NullExpressionNode()
    {
		super();
	}

	boolean isNull()
    {
        return true;
    }
	void Unparse(int indent)
    {
        // Empty.
    }
} // class NullExpressionNode 

