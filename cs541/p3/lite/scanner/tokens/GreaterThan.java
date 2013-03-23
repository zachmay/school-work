package lite.scanner.tokens;

import lite.parse.Symbols;

public class GreaterThan extends Token
{
    public int TOKEN_TYPE = Symbols.GREATER_THAN;

    public GreaterThan(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return ">";
    }

    public int getTokenType()
    {
        return Symbols.GREATER_THAN;
    }
}
