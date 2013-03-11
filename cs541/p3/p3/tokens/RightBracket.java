package p3.tokens;

public class RightBracket extends Token
{
    public static final int TOKEN_TYPE = 14;

    public RightBracket(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "]";
    }
}
