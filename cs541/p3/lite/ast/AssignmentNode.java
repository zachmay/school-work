package lite.ast;

public class AssignmentNode extends StatementNode
{
	public final IdentifierNode target;
	public final ExpressionNode source;

	public AssignmentNode(IdentifierNode id, ExpressionNode e, int line, int col)
    {
		super(line, col);
		this.target = id;
		this.source = e;
	}

	public String unparse(int indent)
    {
        return this.makeTabs(linenum, indent)
                   .append(this.target.unparse(indent))
                   .append(" = ")
                   .append(this.source.unparse(indent))
                   .append(";")
                   .toString();
	}
} // class AssignmentNode 




