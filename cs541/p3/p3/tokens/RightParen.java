package p3.tokens;

public class RightParen extends Token
{
    public static final int TOKEN_TYPE = 5;

    public RightParen(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return ")";
    }
}
