package net.sector42.cs541.tokens;

public class Semicolon extends Token
{
    public static final int TOKEN_TYPE = 2;

    public Semicolon(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return ";";
    }
}
