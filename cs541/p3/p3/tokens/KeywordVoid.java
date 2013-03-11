package p3.tokens;

public class KeywordVoid extends Token
{
    public static final int TOKEN_TYPE = 100;

    public KeywordVoid(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "void";
    }
}
