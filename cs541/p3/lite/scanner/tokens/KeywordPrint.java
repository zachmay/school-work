package lite.scanner.tokens;

import lite.parse.Symbols;

public class KeywordPrint extends Token
{
    public int TOKEN_TYPE = Symbols.K_PRINT;

    public KeywordPrint(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "print";
    }

    public int getTokenType()
    {
        return Symbols.K_PRINT;
    }
}
