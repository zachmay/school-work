package net.sector42.cs541.tokens;

public class Equals extends Token
{
    public static final int TOKEN_TYPE = 19;

    public Equals(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "==";
    }
}
