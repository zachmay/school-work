package p3.ast;

class FieldDeclarationsNode extends ASTNode
{
	static NullFieldDeclarationsNode NULL = new NullFieldDeclarationsNode();
	private DeclarationNode thisField;
	private FieldDeclarationsNode moreFields;

	FieldDeclarationsNode()
    {
		super();
	}

	FieldDeclarationsNode(DeclarationNode d, FieldDeclarationsNode f, int line, int col)
    {
		super(line, col);
		thisField = d;
		moreFields = f;
	}

} // class FieldDeclarationsNode
