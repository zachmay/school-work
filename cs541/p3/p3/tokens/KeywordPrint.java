package p3.tokens;

public class KeywordPrint extends Token
{
    public static final int TOKEN_TYPE = 101;

    public KeywordPrint(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "print";
    }
}
