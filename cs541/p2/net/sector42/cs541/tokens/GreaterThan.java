package net.sector42.cs541.tokens;

public class GreaterThan extends Token
{
    public static final int TOKEN_TYPE = 18;

    public GreaterThan(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return ">";
    }
}
