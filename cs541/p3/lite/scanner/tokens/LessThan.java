package lite.scanner.tokens;

import lite.parse.Symbols;

public class LessThan extends Token
{
    public int TOKEN_TYPE = Symbols.LESS_THAN;

    public LessThan(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "<=";
    }

    public int getTokenType()
    {
        return Symbols.LESS_THAN;
    }
}
