package lite.ast;

import java.lang.StringBuffer;
import java.util.Vector;

public class CastNode extends ExpressionNode
{
    public final TypeNode type;
    public final ExpressionNode expr;

    public CastNode(TypeNode type, ExpressionNode expr, int line, int col)
    {
        super(line, col);
        this.type = type;
        this.expr = expr;
    }

    public String unparse(int indent)
    {
        return new StringBuffer("(")
                        .append(this.type.unparse(indent))
                        .append(")")
                        .append(this.expr.unparse(indent))
                        .toString();
    }
} // class CastNode 




