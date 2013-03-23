package lite.ast;

public class ArrayDeclarationNode extends FieldDeclarationNode
{
    public final TypeNode type;
    public final int dimension;

	public ArrayDeclarationNode(TypeNode type,
                                IdentifierNode id,
                                int dimension,
                                int line, int col)
    {
		super(id, line, col);
        this.type = type;
        this.dimension = dimension;
	}

	public String unparse(int indent)
    {
        return this.makeTabs(this.linenum, indent)
                   .append(this.type.unparse(indent))
                   .append(" ")
                   .append(this.id.unparse(indent))
                   .append("[")
                   .append(this.dimension)
                   .append("];")
                   .toString();
    }
} // class ArrayDeclarationNode

