package lite.scanner.tokens;

import lite.parse.Symbols;

public class LogicalNegation extends Token
{
    public int TOKEN_TYPE = Symbols.LOGICAL_NOT;

    public LogicalNegation(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "!";
    }

    public int getTokenType()
    {
        return Symbols.LOGICAL_NOT;
    }
}
