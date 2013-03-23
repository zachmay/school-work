package lite.scanner.tokens;

import lite.parse.Symbols;

public class KeywordRead extends Token
{
    public int TOKEN_TYPE = Symbols.K_READ;

    public KeywordRead(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "read";
    }

    public int getTokenType()
    {
        return Symbols.K_READ;
    }
}
