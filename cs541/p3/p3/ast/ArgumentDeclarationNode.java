package p3.ast;

// abstract superclass; only subclasses are actually created
abstract class ArgumentDeclarationNode extends ASTNode
{
    ArgumentDeclarationNode()
    {
        super();
    }

    ArgumentDeclarationNode(int l, int c)
    {
        super(l, c);
    }
}
