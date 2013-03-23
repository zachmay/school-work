package lite.scanner.tokens;

import lite.parse.Symbols;

public class RightBrace extends Token
{
    public int TOKEN_TYPE = Symbols.RIGHT_BRACE;

    public RightBrace(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "}";
    }

    public int getTokenType()
    {
        return Symbols.RIGHT_BRACE;
    }
}
