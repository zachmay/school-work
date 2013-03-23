package lite.ast;

public abstract class BinaryOperatorNode extends ExpressionNode
{
	public final ExpressionNode leftOperand;
	public final ExpressionNode rightOperand;

	public BinaryOperatorNode(ExpressionNode e1, ExpressionNode e2, int line, int col)
    {
		super(line, col);
		leftOperand = e1;
		rightOperand = e2;
	}

    protected String unparseBinaryOperator(String opString, int indent)
    {
        return new StringBuffer("(")
                   .append(leftOperand.unparse(indent))
                   .append(" ")
                   .append(opString)
                   .append(" ")
                   .append(rightOperand.unparse(indent))
                   .append(")")
                   .toString();

    }

} // class BinaryOperatorNode 

