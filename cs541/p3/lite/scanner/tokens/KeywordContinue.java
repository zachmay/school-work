package lite.scanner.tokens;

import lite.parse.Symbols;

public class KeywordContinue extends Token
{
    public int TOKEN_TYPE = Symbols.K_CONTINUE;

    public KeywordContinue(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "continue";
    }

    public int getTokenType()
    {
        return Symbols.K_CONTINUE;
    }
}
