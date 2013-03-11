package p3.ast;

import java.util.Vector;

public class MethodDeclarationNode extends ASTNode
{
    public final IdentifierNode name;
    public final Vector<ArgumentDeclarationNode> arguments;
    public final TypeNode returnType;
    public final Vector<FieldDeclarationNode> declarations;
    public final Vector<StatementNode> statements;

    public MethodDeclarationNode(IdentifierNode id,
                          Vector<ArgumentDeclarationNode> args,
                          TypeNode t,
                          Vector<FieldDeclarationNode> fds,
                          Vector<StatementNode> stmts,
                          int line,
                          int col)
    {
        super(line, col);
        name = id;
        arguments = args;
        returnType = t;
        declarations = fds;
        statements = stmts;
    }
} // class MethodDeclarationNode
