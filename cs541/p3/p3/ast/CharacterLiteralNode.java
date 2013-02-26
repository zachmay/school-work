package p3.ast;

class CharacterLiteralNode extends ExpressionNode
{
	private final char charval;

	CharacterLiteralNode(char val, int line, int col)
    {
		super(line, col);
		charval = val;
	}
} // class CharacterLiteralNode 


