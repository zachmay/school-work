package p3.ast;

class ReadNode extends StatementNode
{
    static NullReadNode NULL = new NullReadNode();
    private NameNode targetVar;
    private ReadNode moreReads;

    ReadNode()
    {
        // Empty.
    }

    ReadNode(NameNode n, ReadNode rn, int line, int col)
    {
        super(line, col);
        targetVar = n;
        moreReads = rn;
    }
} // class ReadNode 
