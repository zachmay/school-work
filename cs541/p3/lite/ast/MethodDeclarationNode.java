package lite.ast;

import java.util.Vector;
import java.lang.StringBuffer;

public class MethodDeclarationNode extends MemberDeclarationNode
{
    public final TypeNode returnType;
    public final IdentifierNode id;
    public final Vector<ArgumentDeclarationNode> argDeclarations;
    public final Vector<FieldDeclarationNode> fieldDeclarations;
    public final Vector<StatementNode> statements;

    public MethodDeclarationNode(TypeNode type,
                                 IdentifierNode id,
                                 Vector<ArgumentDeclarationNode> args,
                                 Vector<FieldDeclarationNode> fields,
                                 Vector<StatementNode> stmts,
                                 int line, int col)
    {
        super(line, col);
        this.returnType = type;
        this.id = id;
        this.argDeclarations = args;
        this.fieldDeclarations = fields;
        this.statements = stmts;
    }

    public String unparse(int indent)
    {
        StringBuffer out = this.makeTabs(this.linenum, indent);

        if ( this.returnType == null )
        {
            out.append("void ");
        }
        else
        {
            out.append(this.returnType.unparse(indent))
               .append(" ");
        }
        out.append(this.id.unparse(indent)).append("(");
        for ( ArgumentDeclarationNode arg : this.argDeclarations )
        {
            out.append(arg.unparse(indent)).append(", ");
        }
        out.append(")\n")
           .append(this.makeTabs(this.linenum, indent))
           .append("{\n");
        for ( FieldDeclarationNode decl : this.fieldDeclarations )
        {
            out.append(decl.unparse(indent + 1))
               .append("\n");
        }
        for ( StatementNode stmt : this.statements )
        {
            out.append(stmt.unparse(indent + 1))
               .append("\n");
        }
        out.append(this.makeTabs(this.linenum, indent))
           .append("}");
        return out.toString();
    }
} // class MethodDeclarationNode 

