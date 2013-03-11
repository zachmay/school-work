package p3.ast;

public class BinaryOperatorNode extends ExpressionNode
{
	public final ExpressionNode leftOperand;
	public final ExpressionNode rightOperand;
	public final int operatorCode; // Token code of the operator

	public BinaryOperatorNode(ExpressionNode e1,
            int op, ExpressionNode e2, int line, int col)
    {
		super(line, col);
		operatorCode = op;
		leftOperand = e1;
		rightOperand = e2;
	}

	public static void printOp(int op)
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

	public void Unparse(int indent)
    {
		System.out.print("(");
		leftOperand.Unparse(0);
		printOp(operatorCode);
		rightOperand.Unparse(0);
		System.out.print(")");
	}
} // class BinaryOperatorNode 

