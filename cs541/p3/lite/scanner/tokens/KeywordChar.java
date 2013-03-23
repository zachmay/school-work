package lite.scanner.tokens;

import lite.parse.Symbols;

public class KeywordChar extends Token
{
    public int TOKEN_TYPE = Symbols.K_CHAR;

    public KeywordChar(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "char";
    }

    public int getTokenType()
    {
        return Symbols.K_CHAR;
    }
}
