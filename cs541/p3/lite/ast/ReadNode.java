package lite.ast;

import java.lang.StringBuffer;
import java.util.Vector;

public class ReadNode extends StatementNode
{
    public final Vector<NameNode> args;

    public ReadNode(Vector<NameNode> args, int line, int col)
    {
        super(line, col);
        this.args = args;
    }

    public String unparse(int indent)
    {
        StringBuffer out = this.makeTabs(linenum, indent)
                               .append("read(")
                               .append(this.delimitedUnparse(this.args, ", ", indent))
                               .append(");");

        return out.toString();
    }
} // class ReadNode 




