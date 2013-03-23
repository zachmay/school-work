package lite.ast;

import java.lang.StringBuffer;
import java.util.Vector;

public class PrintNode extends StatementNode
{
    public final Vector<ExpressionNode> args;

    public PrintNode(Vector<ExpressionNode> args, int line, int col)
    {
        super(line, col);
        this.args = args;
    }

    public String unparse(int indent)
    {
        StringBuffer out = this.makeTabs(linenum, indent)
                               .append("print(")
                               .append(this.delimitedUnparse(this.args, ", ", indent))
                               .append(");");

        return out.toString();
    }
} // class PrintNode 




