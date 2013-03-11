package p3.tokens;

public class KeywordChar extends Token
{
    public static final int TOKEN_TYPE = 35;

    public KeywordChar(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "char";
    }
}
