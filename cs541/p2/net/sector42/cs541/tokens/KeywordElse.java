package net.sector42.cs541.tokens;

public class KeywordElse extends Token
{
    public static final int TOKEN_TYPE = 32;

    public KeywordElse(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "else";
    }
}
