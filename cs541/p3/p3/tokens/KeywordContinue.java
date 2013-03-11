package p3.tokens;

public class KeywordContinue extends Token
{
    public static final int TOKEN_TYPE = 51;

    public KeywordContinue(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "continue";
    }
}
