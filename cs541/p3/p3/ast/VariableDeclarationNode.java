package p3.ast;

class VariableDeclarationNode extends DeclarationNode
{
	private final IdentifierNode varName;
	private final TypeNode varType;
	private final ExpressionNode initValue;

	VariableDeclarationNode(IdentifierNode id, TypeNode t, ExpressionNode e, int line, int col)
    {
		super(line, col);
		varName = id;
		varType = t;
		initValue = e;
	}
} // class VariableDeclarationNode
