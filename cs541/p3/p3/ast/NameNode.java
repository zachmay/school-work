package p3.ast;

public class NameNode extends ExpressionNode
{
	public NameNode(IdentifierNode id, ExpressionNode expr, int line, int col)
    {
		super(line, col);
		varName = id;
		subscriptVal = expr;
	}

	public void unparse(int indent)
    {
		varName.unparse(0); // Subscripts not allowed in CSX Lite
	}

	public final IdentifierNode varName;
	public final ExpressionNode subscriptVal;
} // class NameNode 

