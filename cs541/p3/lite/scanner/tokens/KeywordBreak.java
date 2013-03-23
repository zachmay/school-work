package lite.scanner.tokens;

import lite.parse.Symbols;

public class KeywordBreak extends Token
{
    public int TOKEN_TYPE = Symbols.K_BREAK;

    public KeywordBreak(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "break";
    }

    public int getTokenType()
    {
        return Symbols.K_BREAK;
    }
}
