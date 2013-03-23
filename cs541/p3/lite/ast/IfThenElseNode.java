package lite.ast;

import java.lang.StringBuffer;

public class IfThenElseNode extends StatementNode
{
	public final ExpressionNode condition;
	public final StatementNode thenPart;
    public final StatementNode elsePart;

	public IfThenElseNode(ExpressionNode e, StatementNode s1, StatementNode s2, int line, int col)
    {
		super(line, col);
		condition = e;
		thenPart = s1;
        elsePart = s2;
	}

	public String unparse(int indent)
    {
        StringBuffer out = this.makeTabs(this.linenum, indent)
                                 .append("if ( ")
                                 .append(condition.unparse(indent))
                                 .append(" )\n")
                                 .append(thenPart.unparse(indent + 1));
        if ( this.elsePart != null )
        {
            out.append("\n")
               .append(this.makeTabs(this.linenum, indent))
               .append("else\n")
               .append(elsePart.unparse(indent + 1));
        }

        return out.toString();
	}
} // class IfThenNode 
