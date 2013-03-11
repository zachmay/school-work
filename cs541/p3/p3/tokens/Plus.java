package p3.tokens;

public class Plus extends Token
{
    public static final int TOKEN_TYPE = 23;

    public Plus(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "+";
    }
}
