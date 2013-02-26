package net.sector42.cs541.tokens;

public class NotEquals extends Token
{
    public static final int TOKEN_TYPE = 20;

    public NotEquals(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "!=";
    }
}
