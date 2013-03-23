package lite.scanner.tokens;

import lite.parse.Symbols;

public class KeywordVoid extends Token
{
    public int TOKEN_TYPE = Symbols.K_VOID;

    public KeywordVoid(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "void";
    }

    public int getTokenType()
    {
        return Symbols.K_VOID;
    }
}
