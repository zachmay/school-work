package p3.tokens;

public class Comma extends Token
{
    public static final int TOKEN_TYPE = 3;

    public Comma(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return ",";
    }
}
