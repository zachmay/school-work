package p3.tokens;

public class LessThan extends Token
{
    public static final int TOKEN_TYPE = 17;

    public LessThan(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "<=";
    }
}
