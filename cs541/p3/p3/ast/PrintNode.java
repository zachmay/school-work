package p3.ast;

import java.util.Vector;

public class PrintNode extends StatementNode
{
	public Vector<ExpressionNode> outputExpressions;

	public PrintNode(int line, int col)
    {
        super(line, col);
        outputExpressions = new Vector<ExpressionNode>();
    }

	public PrintNode(Vector<ExpressionNode> exprs, int line, int col)
    {
		super(line, col);
        outputExpressions = exprs;
	}
} // class PrintNode 

