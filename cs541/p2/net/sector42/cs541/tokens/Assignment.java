package net.sector42.cs541.tokens;

public class Assignment extends Token
{
    public static final int TOKEN_TYPE = 6;

    public Assignment(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "=";
    }
}
