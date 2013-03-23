package lite.ast;

import java.lang.StringBuffer;

public class ArgumentDeclarationNode extends ASTNode
{
    public final TypeNode type;
    public final IdentifierNode id;
    public final boolean isArray;

	public ArgumentDeclarationNode(TypeNode type, IdentifierNode id, boolean isArray, int line, int col)
    {
		super(line, col);
        this.type = type;
        this.id = id;
        this.isArray = isArray;
	}

    public String unparse(int indent)
    {
        StringBuffer out = new StringBuffer(this.type.unparse(indent))
                                    .append(" ")
                                    .append(this.id.unparse(indent));

        if ( this.isArray )
        {
            out.append("[]");
        }

        return out.toString();
    }
} // class TypeNode 




