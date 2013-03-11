package p3.tokens;

public class KeywordFalse extends Token
{
    public static final int TOKEN_TYPE = 40;

    public KeywordFalse(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "false";
    }
}
