package net.sector42.cs541.tokens;

public class Times extends Token
{
    public static final int TOKEN_TYPE = 25;

    public Times(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "*";
    }
}
