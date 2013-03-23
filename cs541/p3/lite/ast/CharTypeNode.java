package lite.ast;

public class CharTypeNode extends TypeNode
{
	public CharTypeNode(int line, int col)
    {
		super(line, col);
	}

    public String unparse(int indent)
    {
        return "char";
    }
} // class CharTypeNode 




