package lite.scanner.tokens;

import lite.parse.Symbols;

public class KeywordElse extends Token
{
    public int TOKEN_TYPE = Symbols.K_ELSE;

    public KeywordElse(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "else";
    }

    public int getTokenType()
    {
        return Symbols.K_ELSE;
    }
}
