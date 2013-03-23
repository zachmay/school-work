package lite.scanner.tokens;

import lite.parse.Symbols;

public class Divide extends Token
{
    public int TOKEN_TYPE = Symbols.DIVIDE;

    public Divide(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "/";
    }

    public int getTokenType()
    {
        return Symbols.DIVIDE;
    }
}
