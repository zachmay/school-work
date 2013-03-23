package lite.scanner.tokens;

import lite.parse.Symbols;

public class KeywordFalse extends Token
{
    public int TOKEN_TYPE = Symbols.K_FALSE;

    public KeywordFalse(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "false";
    }

    public int getTokenType()
    {
        return Symbols.K_FALSE;
    }
}
