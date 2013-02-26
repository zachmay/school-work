package p3.ast;

class BlockNode extends StatementNode
{
	private final FieldDeclarationsNode decls;
	private final StatementsNode stmts;

	BlockNode(FieldDeclarationsNode f, StatementsNode s, int line, int col)
    {
		super(line, col);
		decls = f;
		stmts = s;
	}
} // class BlockNode 

