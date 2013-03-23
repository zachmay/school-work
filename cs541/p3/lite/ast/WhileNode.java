package lite.ast;

import java.lang.StringBuffer;

public class WhileNode extends StatementNode
{
	public final ExpressionNode condition;
	public final StatementNode body;
    public final IdentifierNode label;

	public WhileNode(ExpressionNode condition, StatementNode body, IdentifierNode label, int line, int col)
    {
		super(line, col);
		this.condition = condition;
        this.body = body;
        this.label = label;
	}

	public String unparse(int indent)
    {
        StringBuffer out = this.makeTabs(this.linenum, indent);

        if ( this.label != null )
        {
            out.append(this.label.unparse(indent))
               .append(" : ");
        }

        out.append("while ( ")
           .append(this.condition.unparse(indent))
           .append(" )\n")
           .append(this.body.unparse(indent + 1));

        return out.toString();
	}
} // class IfThenNode 
