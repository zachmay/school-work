package p3.tokens;

public class KeywordConst extends Token
{
    public static final int TOKEN_TYPE = 29;

    public KeywordConst(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "const";
    }
}
