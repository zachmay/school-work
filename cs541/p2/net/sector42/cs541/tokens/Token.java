package net.sector42.cs541.tokens;

public class Token
{
    public static int TOKEN_TYPE = 1;

    int linenum;
    int colnum;

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

    public String toString()
    {
        return new StringBuffer("Unknown Token(").append(linenum)
                                                 .append(", ")
                                                 .append(colnum)
                                                 .append(")")
                                                 .toString();
    }
}

