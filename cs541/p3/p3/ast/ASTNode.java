package p3.ast;

public abstract class ASTNode
{
    // abstract superclass; only subclasses are actually created

    public int linenum;
    public int colnum;

    static void genIndent(int indent)
    {
        for (int i = 1; i <= indent; i += 1)
        {
            System.out.print("\t");
        }
    } // genIndent

    public ASTNode()
    {
        linenum = -1;
        colnum  = -1;
    } // ASTNode()

    public ASTNode(int line, int col)
    {
        linenum = line;
        colnum  = col;
    } // ASTNode(line, col)

    public boolean isNull()
    {
        return false; // often redefined in a subclass
    } // isNull()

    public void unparse(int indent)
    {
        // Typically redefined in subclasses.
    } // unparse()
} // class ASTNode

