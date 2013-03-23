package lite.ast;

import java.lang.StringBuffer;
import java.util.Vector;

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

    protected StringBuffer makeTabs(int linenum, int indent)
    {
        StringBuffer tabs = new StringBuffer(String.format("%5d: ", linenum));
        for ( int i = 0; i < indent; i++ )
        {
            tabs.append("    ");
        }
        return tabs;
    }

    protected String delimitedUnparse(Vector<? extends ASTNode> nodes, String delimiter, int indent)
    {
        StringBuffer out = new StringBuffer();
        int size = nodes.size();
        for ( int i = 0; i < size; i++ )
        {
            out.append(nodes.elementAt(i).unparse(indent));
            if ( i != size - 1 )
            {
                out.append(delimiter);
            }
        }
        return out.toString();
    }

    public String unparse(int indent)
    {
        // Typically redefined in subclasses.
        return "";
    } // unparse()
} // class ASTNode

