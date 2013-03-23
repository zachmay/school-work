package lite.scanner.tokens;

import lite.parse.Symbols;

public class GreaterEqual extends Token
{
    public int TOKEN_TYPE = Symbols.GREATER_EQUAL;

    public GreaterEqual(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return ">=";
    }

    public int getTokenType()
    {
        return Symbols.GREATER_EQUAL;
    }
}
