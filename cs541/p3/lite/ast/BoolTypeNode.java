package lite.ast;

public class BoolTypeNode extends TypeNode
{
	public BoolTypeNode(int line, int col)
    {
		super(line, col);
	}

    public String unparse(int indent)
    {
        return "bool";
    }
} // class BoolTypeNode 




