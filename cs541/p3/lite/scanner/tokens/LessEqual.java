package lite.scanner.tokens;

import lite.parse.Symbols;

public class LessEqual extends Token
{
    public int TOKEN_TYPE = Symbols.LESS_EQUAL;

    public LessEqual(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "<=";
    }

    public int getTokenType()
    {
        return Symbols.LESS_EQUAL;
    }
}
