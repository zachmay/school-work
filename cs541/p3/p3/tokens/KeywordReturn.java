package p3.tokens;

public class KeywordReturn extends Token
{
    public static final int TOKEN_TYPE = 38;

    public KeywordReturn(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "return";
    }
}
