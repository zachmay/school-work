package p3.tokens;

public class LogicalOr extends Token
{
    public static final int TOKEN_TYPE = 16;

    public LogicalOr(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "||";
    }
}
