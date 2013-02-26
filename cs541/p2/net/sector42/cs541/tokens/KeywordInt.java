package net.sector42.cs541.tokens;

public class KeywordInt extends Token
{
    public static final int TOKEN_TYPE = 34;

    public KeywordInt(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "int";
    }
}
