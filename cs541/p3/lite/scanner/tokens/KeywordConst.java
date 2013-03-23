package lite.scanner.tokens;

import lite.parse.Symbols;

public class KeywordConst extends Token
{
    public int TOKEN_TYPE = Symbols.K_CONST;

    public KeywordConst(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "const";
    }

    public int getTokenType()
    {
        return Symbols.K_CONST;
    }
}
