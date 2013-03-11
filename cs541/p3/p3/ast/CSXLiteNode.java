package p3.ast;

public class CSXLiteNode extends ASTNode
{
    // This node is used to root CSX lite programs 

    csxLiteNode(StatementsNode stmts, int line, int col)
    {
        super(line, col);
        progStmts = stmts;
    } // csxLiteNode()

    void unparse(int indent) {
        System.out.println(linenum + ":" + " {");
        progStmts.unparse(1);
        System.out.println(linenum + ":" + " } EOF");
    } // unparse()

    private final stmtsNode progStmts;
} // class csxLiteNode







