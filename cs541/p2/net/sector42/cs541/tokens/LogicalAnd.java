package net.sector42.cs541.tokens;

public class LogicalAnd extends Token
{
    public static final int TOKEN_TYPE = 15;

    public LogicalAnd(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "&&";
    }
}
