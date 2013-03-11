package p3.tokens;

public class Colon extends Token
{
    public static final int TOKEN_TYPE = 52;

    public Colon(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return ":";
    }
}
