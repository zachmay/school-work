package lite.scanner.tokens;

import lite.parse.Symbols;

public class KeywordIf extends Token
{
    public int TOKEN_TYPE = Symbols.K_IF;

    public KeywordIf(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "if";
    }

    public int getTokenType()
    {
        return Symbols.K_IF;
    }
}
