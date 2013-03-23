package lite.scanner.tokens;

import lite.parse.Symbols;

public class KeywordReturn extends Token
{
    public int TOKEN_TYPE = Symbols.K_RETURN;

    public KeywordReturn(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "return";
    }

    public int getTokenType()
    {
        return Symbols.K_RETURN;
    }
}
