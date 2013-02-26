package net.sector42.cs541.tokens;

public class Divide extends Token
{
    public static final int TOKEN_TYPE = 26;

    public Divide(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "/";
    }
}
