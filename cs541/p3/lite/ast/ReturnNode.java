package lite.ast;

import java.lang.StringBuffer;

public class ReturnNode extends StatementNode
{
    public final ExpressionNode returnValue;

    public ReturnNode(ExpressionNode e, int line, int col)
    {
        super(line, col);
        this.returnValue = e;
    }

    public String unparse(int indent)
    {
        StringBuffer out = this.makeTabs(linenum, indent)
                               .append("return");

        if ( this.returnValue != null )
        {
            out.append(" ")
               .append(this.returnValue.unparse(indent));
        }

        return out.append(";").toString();
    }
} // class ReturnNode 




