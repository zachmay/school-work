package p3.tokens;

public class LeftBracket extends Token
{
    public static final int TOKEN_TYPE = 13;

    public LeftBracket(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "[";
    }
}
