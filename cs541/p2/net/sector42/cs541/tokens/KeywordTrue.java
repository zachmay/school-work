package net.sector42.cs541.tokens;

public class KeywordTrue extends Token
{
    public static final int TOKEN_TYPE = 39;

    public KeywordTrue(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "true";
    }
}
