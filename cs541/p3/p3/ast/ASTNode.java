package p3;

abstract class ASTNode
{
    // abstract superclass; only subclasses are actually created

    int linenum;
    int colnum;

    static void genIndent(int indent)
    {
        for (int i = 1; i <= indent; i += 1)
        {
            System.out.print("\t");
        }
    } // genIndent

    ASTNode()
    {
        linenum = -1;
        colnum  = -1;
    } // ASTNode()

    ASTNode(int line, int col)
    {
        linenum = line;
        colnum  = col;
    } // ASTNode(line, col)

    boolean isNull()
    {
        return false; // often redefined in a subclass
    } // isNull()

    void unparse(int indent)
    {
        // Typically redefined in subclasses.
    } // unparse()
} // class ASTNode

