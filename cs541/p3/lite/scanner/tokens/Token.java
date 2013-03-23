package lite.scanner.tokens;

public class Token
{
    public int TOKEN_TYPE = -999;

    public int linenum;
    public int colnum;

    // Token should not be instantiated directly. Use a subclass.
    protected Token(int line, int col)
    {
        linenum = line;
        colnum = col;
    }

    public int getLine()
    {
        return linenum;
    }

    public int getColumn()
    {
        return colnum;
    }

    public boolean isEOF()
    {
        return false;
    }

    public int getTokenType()
    {
        return this.TOKEN_TYPE;
    }

    public String toString()
    {
        return new StringBuffer("Unknown Token(").append(linenum)
                                                 .append(", ")
                                                 .append(colnum)
                                                 .append(")")
                                                 .toString();
    }
}

