package lite.ast;

public class ConstantDeclarationNode extends FieldDeclarationNode
{
    public final ExpressionNode initialValue;

	public ConstantDeclarationNode(IdentifierNode id,
                                   ExpressionNode init, 
                                   int line, int col)
    {
		super(id, line, col);
        this.initialValue = init;
	}

	public String unparse(int indent)
    {
        return this.makeTabs(this.linenum, indent)
                   .append("const ")
                   .append(this.id.unparse(indent))
                   .append(" = ")
                   .append(this.initialValue.unparse(indent))
                   .append(";")
                   .toString();
    }
} // class ConstantDeclarationNode 

