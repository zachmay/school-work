package p3.tokens;

public class LeftBrace extends Token
{
    public static final int TOKEN_TYPE = 11;

    public LeftBrace(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "{";
    }
}
