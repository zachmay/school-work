package p3.tokens;

public class KeywordIf extends Token
{
    public static final int TOKEN_TYPE = 30;

    public KeywordIf(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "if";
    }
}
