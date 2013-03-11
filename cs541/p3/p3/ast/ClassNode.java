package p3.ast;

import java.util.Vector;

public class ClassNode extends ASTNode
{
	public final IdentifierNode className;
	public final Vector<FieldDeclarationNode> fields;
	public final Vector<MethodDeclarationNode> methods;

	public ClassNode(IdentifierNode id,
                     Vector<FieldDeclarationNode> fields,
                     Vector<MethodDeclarationNode> methods, int line, int col)
    {
		super(line, col);
		this.className = id;
        this.fields = fields;
        this.methods = methods;
	} // classNode
} // class classNode
