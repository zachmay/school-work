package lite.ast;

import java.lang.StringBuffer;

public class NameNode extends ExpressionNode
{
    public final IdentifierNode id;
    public final ExpressionNode indexExpression;

	public NameNode(IdentifierNode id, ExpressionNode index, int line, int col)
    {
		super(line, col);
        this.id = id;
        this.indexExpression = index;
	}

    public String unparse(int indent)
    {
        StringBuffer out = new StringBuffer(id.unparse(indent));

        if ( this.indexExpression != null )
        {
            out.append("[")
               .append(this.indexExpression.unparse(indent))
               .append("]");
        }

        return out.toString();
    }
} // class NameNode 

