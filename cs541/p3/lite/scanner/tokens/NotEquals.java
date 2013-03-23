package lite.scanner.tokens;

import lite.parse.Symbols;

public class NotEquals extends Token
{
    public int TOKEN_TYPE = Symbols.NOT_EQUALS;

    public NotEquals(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "!=";
    }

    public int getTokenType()
    {
        return Symbols.NOT_EQUALS;
    }
}
