package lite.scanner.tokens;

import lite.parse.Symbols;

public class KeywordClass extends Token
{
    public KeywordClass(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "class";
    }

    public int getTokenType()
    {
        return Symbols.K_CLASS;
    }
}
