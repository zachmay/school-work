package p3.tokens;

public class EOF extends Token
{
    public static final int TOKEN_TYPE = 2;

    public EOF(int line, int col)
    {
        super(line, col);
    }

    public boolean isEOF()
    {
        return true;
    }

    public String toString()
    {
        return "EOF";
    }
}
