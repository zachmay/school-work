package p3.tokens;

public class KeywordRead extends Token
{
    public static final int TOKEN_TYPE = 33;

    public KeywordRead(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "read";
    }
}
