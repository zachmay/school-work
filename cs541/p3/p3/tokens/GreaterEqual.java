package p3.tokens;

public class GreaterEqual extends Token
{
    public static final int TOKEN_TYPE = 22;

    public GreaterEqual(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return ">=";
    }
}
