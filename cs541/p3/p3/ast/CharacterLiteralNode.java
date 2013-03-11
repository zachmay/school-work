package p3.ast;

public class CharacterLiteralNode extends ExpressionNode
{
	public final char charval;

	public CharacterLiteralNode(char val, int line, int col)
    {
		super(line, col);
		charval = val;
	}
} // class CharacterLiteralNode 


