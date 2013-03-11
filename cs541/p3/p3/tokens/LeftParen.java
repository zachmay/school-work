package p3.tokens;

public class LeftParen extends Token
{
    public static final int TOKEN_TYPE = 4;

    public LeftParen(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "(";
    }
}
