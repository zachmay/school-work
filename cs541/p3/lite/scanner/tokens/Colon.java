package lite.scanner.tokens;

import lite.parse.Symbols;

public class Colon extends Token
{
    public int TOKEN_TYPE = Symbols.COLON;

    public Colon(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return ":";
    }

    public int getTokenType()
    {
        return Symbols.COLON;
    }
}
