package lite.scanner.tokens;

import lite.parse.Symbols;

public class Semicolon extends Token
{
    public int TOKEN_TYPE = Symbols.SEMICOLON;

    public Semicolon(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return ";";
    }

    public int getTokenType()
    {
        return Symbols.SEMICOLON;
    }
}
