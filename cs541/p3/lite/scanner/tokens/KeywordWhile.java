package lite.scanner.tokens;

import lite.parse.Symbols;

public class KeywordWhile extends Token
{
    public int TOKEN_TYPE = Symbols.K_WHILE;

    public KeywordWhile(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "while";
    }

    public int getTokenType()
    {
        return Symbols.K_WHILE;
    }
}
