package p3.ast;

class BinaryOperatorNode extends ExpressionNode
{
	private final ExpressionNode leftOperand;
	private final ExpressionNode rightOperand;
	private final int operatorCode; // Token code of the operator

	BinaryOperatorNode(ExpressionNode e1, int op, ExpressionNode e2, int line, int col)
    {
		super(line, col);
		operatorCode = op;
		leftOperand = e1;
		rightOperand = e2;
	}

	static void printOp(int op)
    {
		switch (op)
        {
			case sym.PLUS:
				System.out.print(" + ");
				break;
			case sym.MINUS:
				System.out.print(" - ");
				break;
			default:
				throw new Error("printOp: case not found");
		}
	}

	void Unparse(int indent)
    {
		System.out.print("(");
		leftOperand.Unparse(0);
		printOp(operatorCode);
		rightOperand.Unparse(0);
		System.out.print(")");
	}
} // class BinaryOperatorNode 

