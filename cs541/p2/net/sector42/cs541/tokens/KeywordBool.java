package net.sector42.cs541.tokens;

public class KeywordBool extends Token
{
    public static final int TOKEN_TYPE = 36;

    public KeywordBool(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "bool";
    }
}
