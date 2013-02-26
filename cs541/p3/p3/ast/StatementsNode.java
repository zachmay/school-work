package p3.ast;

class StatementsNode extends ASTNode
{
	static NullStatementsNode NULL = new NullStatementsNode();
	private StatementNode thisStmt;
	private StatementsNode moreStmts;

	StatementsNode(StatementNode stmt, StatementsNode stmts, int line, int col)
    {
		super(line, col);
		thisStmt = stmt;
		moreStmts = stmts;
	}

	StatementsNode()
    {
        // Empty.
    }

	void unparse(int indent)
    {
		thisStmt.Unparse(indent);
		moreStmts.Unparse(indent);
	}
} // class StatementsNode
