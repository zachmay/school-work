package p3.ast;

class ClassNode extends ASTNode
{
	private final identNode className;
	private final memberDeclsNode members;

	ClassNode(identNode id, memberDeclsNode memb, int line, int col)
    {
		super(line, col);
		className = id;
		members = memb;
	} // classNode
} // class classNode
