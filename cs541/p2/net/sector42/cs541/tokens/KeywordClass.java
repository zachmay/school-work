package net.sector42.cs541.tokens;

public class KeywordClass extends Token
{
    public static final int TOKEN_TYPE = 28;

    public KeywordClass(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "class";
    }
}
