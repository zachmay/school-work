package net.sector42.cs541.tokens;

public class KeywordBreak extends Token
{
    public static final int TOKEN_TYPE = 50;

    public KeywordBreak(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "break";
    }
}
