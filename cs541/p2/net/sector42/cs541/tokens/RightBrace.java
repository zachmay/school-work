package net.sector42.cs541.tokens;

public class RightBrace extends Token
{
    public static final int TOKEN_TYPE = 12;

    public RightBrace(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "}";
    }
}
