package p3.ast;

class PrintNode extends StatementNode
{
	private ExpressionNode outputValue;
	private PrintNode morePrints;

	PrintNode()
    {
        // Empty.
    }

	PrintNode(ExpressionNode val, PrintNode pn, int line, int col)
    {
		super(line, col);
		outputValue = val;
		morePrints = pn;
	}

	static NullPrintNode NULL = new NullPrintNode();
} // class PrintNode 

