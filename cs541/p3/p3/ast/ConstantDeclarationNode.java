package p3.ast;

public class ConstantDeclarationNode extends DeclarationNode
{
	public final IdentifierNode varName;
	public final ExpressionNode initValue;

	public ConstantDeclarationNode(IdentifierNode id, ExpressionNode e, int line, int col)
    {
		super(line, col);
		varName = id;
		initValue = e;
	}
} // class ConstantDeclarationNode
