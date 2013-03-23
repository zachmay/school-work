package lite.scanner.tokens;

import lite.parse.Symbols;

public class KeywordBool extends Token
{
    public int TOKEN_TYPE = Symbols.K_BOOL;

    public KeywordBool(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "bool";
    }

    public int getTokenType()
    {
        return Symbols.K_BOOL;
    }
}
