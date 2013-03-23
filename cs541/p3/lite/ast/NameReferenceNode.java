package lite.ast;

public class NameReferenceNode extends ExpressionNode
{
    public final NameNode name;

	public NameReferenceNode(NameNode name, int line, int col)
    {
		super(line, col);
        this.name = name;
	}

	public String unparse(int indent)
    {
        return this.name.unparse(indent);
	}
} // class NameReferenceNode 

