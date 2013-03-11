package p3.tokens;

public class Token
{
    public static int TOKEN_TYPE = 1;

    public int linenum;
    public int colnum;

    // Token should not be instantiated directly. Use a subclass.
    protected Token(int line, int col)
    {
        linenum = line;
        colnum = col;
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

