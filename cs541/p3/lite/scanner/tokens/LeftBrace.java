package lite.scanner.tokens;

import lite.parse.Symbols;

public class LeftBrace extends Token
{
    public int TOKEN_TYPE = Symbols.LEFT_BRACE;

    public LeftBrace(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "{";
    }

    public int getTokenType()
    {
        return Symbols.LEFT_BRACE;
    }
}
