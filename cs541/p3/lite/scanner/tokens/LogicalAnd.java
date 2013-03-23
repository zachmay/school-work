package lite.scanner.tokens;

import lite.parse.Symbols;

public class LogicalAnd extends Token
{
    public int TOKEN_TYPE = Symbols.LOGICAL_AND;

    public LogicalAnd(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "&&";
    }

    public int getTokenType()
    {
        return Symbols.LOGICAL_AND;
    }
}
