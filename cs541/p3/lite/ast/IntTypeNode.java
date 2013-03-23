package lite.ast;

public class IntTypeNode extends TypeNode
{
	public IntTypeNode(int line, int col)
    {
		super(line, col);
	}

    public String unparse(int indent)
    {
        return "int";
    }
} // class IntTypeNode 




