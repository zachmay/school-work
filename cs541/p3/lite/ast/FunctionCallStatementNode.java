package lite.ast;

import java.lang.StringBuffer;
import java.util.Vector;

public class FunctionCallStatementNode extends StatementNode
{
    public final IdentifierNode id;
    public final Vector<ExpressionNode> args;

    public FunctionCallStatementNode(IdentifierNode id,
            Vector<ExpressionNode> args,
            int line, int col)
    {
        super(line, col);
        this.id = id;
        this.args = args;
    }

    public String unparse(int indent)
    {
        StringBuffer out = this.makeTabs(linenum, indent)
                               .append(this.id.unparse(indent))
                               .append("(")
                               .append(this.delimitedUnparse(this.args, ", ", indent))
                               .append(");");

        return out.toString();
    }
} // class FunctionCallStatementNode 




