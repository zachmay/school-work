package lite.ast;

import java.lang.StringBuffer;
import java.util.Vector;

public class CompoundStatementNode extends StatementNode
{
    public final Vector<FieldDeclarationNode> fields;
    public final Vector<StatementNode> statements;

    public CompoundStatementNode(Vector<FieldDeclarationNode> fields,
            Vector<StatementNode> statements,
            int line, int col)
    {
        super(line, col);

        this.fields = fields;
        this.statements = statements;
    }

    public String unparse(int indent)
    {
        // "Outdent" the braces.
        StringBuffer out = this.makeTabs(linenum, indent - 1)
                               .append("{\n");

        for ( FieldDeclarationNode field : this.fields )
        {
            out.append(field.unparse(indent))
               .append("\n");
        }

        for ( StatementNode statement : this.statements )
        {
            out.append(statement.unparse(indent))
               .append("\n");
        }

        return out.append(this.makeTabs(linenum, indent - 1))
                  .append("}")
                  .toString();
    }
} // class CompoundStatementNode 




