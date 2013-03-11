package p3.tokens;

public class LogicalNegation extends Token
{
    public static final int TOKEN_TYPE = 27;

    public LogicalNegation(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "!";
    }
}
