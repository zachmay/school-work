package lite.scanner.tokens;

import lite.parse.Symbols;

public class KeywordTrue extends Token
{
    public int TOKEN_TYPE = Symbols.K_TRUE;

    public KeywordTrue(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "true";
    }

    public int getTokenType()
    {
        return Symbols.K_TRUE;
    }
}
