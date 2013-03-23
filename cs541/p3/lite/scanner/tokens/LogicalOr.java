package lite.scanner.tokens;

import lite.parse.Symbols;

public class LogicalOr extends Token
{
    public int TOKEN_TYPE = Symbols.LOGICAL_OR;

    public LogicalOr(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "||";
    }

    public int getTokenType()
    {
        return Symbols.LOGICAL_OR;
    }
}
