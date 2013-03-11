package p3.ast;

public class VariableDeclarationNode extends FieldDeclarationNode
{
	public final TypeNode varType;
	public final IdentifierNode varName;
	public final ExpressionNode initValue;

	public VariableDeclarationNode(TypeNode t, IdentifierNode id,
            ExpressionNode e, int line, int col)
    {
		super(line, col);
		varName = id;
		varType = t;
		initValue = e;
	}
} // class VariableDeclarationNode
