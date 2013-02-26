package net.sector42.cs541.tokens;

public class LessEqual extends Token
{
    public static final int TOKEN_TYPE = 21;

    public LessEqual(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "<=";
    }
}
