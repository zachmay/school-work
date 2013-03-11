package p3.ast;

import java.util.Vector;

public class ReadNode extends StatementNode
{
    public Vector<NameNode> targetVars;

    public ReadNode(int line, int col)
    {
        super(line, col);
        targetVars = new Vector<NameNode>();
    }

    public ReadNode(Vector<NameNode> vars, int line, int col)
    {
        super(line, col);
        targetVars = vars;
    }
} // class ReadNode 
