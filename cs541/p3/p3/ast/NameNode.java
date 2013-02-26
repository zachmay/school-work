package p3.ast;

class NameNode extends ExpressionNode
{
	NameNode(IdentifierNode id, ExpressionNode expr, int line, int col)
    {
		super(line, col);
		varName = id;
		subscriptVal = expr;
	}

	void unparse(int indent)
    {
		varName.unparse(0); // Subscripts not allowed in CSX Lite
	}

	private final IdentifierNode varName;
	private final ExpressionNode subscriptVal;
} // class NameNode 

