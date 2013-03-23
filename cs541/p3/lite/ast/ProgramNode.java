package lite.ast;

import java.util.Vector;
import java.lang.StringBuffer;

public class ProgramNode extends ASTNode
{
    public final IdentifierNode id;
	public final Vector<MemberDeclarationNode> memberDeclarations;

	public ProgramNode(IdentifierNode id,
            Vector<MemberDeclarationNode> memberDeclarations,
            int line, int col)
    {
		super(line, col);
        this.id = id;
        this.memberDeclarations = memberDeclarations;
	} 

    public String unparse(int indent)
    {
        StringBuffer out = this.makeTabs(this.linenum, indent)
                               .append("class ")
                               .append(id.identifierText)
                               .append("\n")
                               .append(this.makeTabs(this.linenum, indent))
                               .append("{\n");

        for ( MemberDeclarationNode decl : this.memberDeclarations )
        {
            out.append(decl.unparse(indent + 1))
               .append("\n");
        }

        return out.append(this.makeTabs(this.linenum, indent))
                  .append("}").toString();
    }
} // class classNode
