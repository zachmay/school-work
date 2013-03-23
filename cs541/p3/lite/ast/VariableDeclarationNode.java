package lite.ast;

public class VariableDeclarationNode extends FieldDeclarationNode
{
    public final TypeNode type;
    public final ExpressionNode initialValue;

	public VariableDeclarationNode(TypeNode type,
                                   IdentifierNode id,
                                   ExpressionNode init, 
                                   int line, int col)
    {
		super(id, line, col);
        this.type = type;
        this.initialValue = init;
	}

	public String unparse(int indent)
    {
        StringBuffer out =  this.makeTabs(this.linenum, indent)
                                  .append(this.type.unparse(indent))
                                  .append(" ")
                                  .append(this.id.unparse(indent));

        if ( this.initialValue != null )
        {
            out.append(" = ")
               .append(this.initialValue.unparse(indent));
        }

        return out.append(";").toString();
    }
} // class VariableDeclarationNode 

