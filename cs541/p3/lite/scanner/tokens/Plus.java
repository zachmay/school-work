package lite.scanner.tokens;

import lite.parse.Symbols;

public class Plus extends Token
{
    public int TOKEN_TYPE = Symbols.PLUS;

    public Plus(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "+";
    }

    public int getTokenType()
    {
        return Symbols.PLUS;
    }
}
