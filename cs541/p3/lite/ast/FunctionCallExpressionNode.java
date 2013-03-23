package lite.ast;

import java.lang.StringBuffer;
import java.util.Vector;

public class FunctionCallExpressionNode extends ExpressionNode
{
    public final IdentifierNode id;
    public final Vector<ExpressionNode> args;

    public FunctionCallExpressionNode(IdentifierNode id,
            Vector<ExpressionNode> args,
            int line, int col)
    {
        super(line, col);
        this.id = id;
        this.args = args;
    }

    public String unparse(int indent)
    {
        StringBuffer out = new StringBuffer()
                               .append(this.id.unparse(indent))
                               .append("(")
                               .append(this.delimitedUnparse(this.args, ", ", indent))
                               .append(")");

        return out.toString();
    }
} // class FunctionCallExpressionNode 




