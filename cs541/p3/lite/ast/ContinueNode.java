package lite.ast;

import java.lang.StringBuffer;

public class ContinueNode extends StatementNode
{
    public final IdentifierNode id;

    public ContinueNode(IdentifierNode id, int line, int col)
    {
        super(line, col);
        this.id = id;
    }

    public String unparse(int indent)
    {
        StringBuffer out = this.makeTabs(linenum, indent)
                               .append("continue ")
                               .append(this.id.unparse(indent))
                               .append(";");

        return out.toString();
    }
} // class ContinueNode 




