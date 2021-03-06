package lite.scanner.tokens;

import lite.parse.Symbols;

public class KeywordInt extends Token
{
    public int TOKEN_TYPE = Symbols.K_INT;

    public KeywordInt(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "int";
    }

    public int getTokenType()
    {
        return Symbols.K_INT;
    }
}
