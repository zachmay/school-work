package p3.ast;

public class BlockNode extends StatementNode
{
	public final FieldDeclarationsNode decls;
	public final StatementsNode stmts;

	public BlockNode(FieldDeclarationsNode f, StatementsNode s, int line, int col)
    {
		super(line, col);
		decls = f;
		stmts = s;
	}
} // class BlockNode 

