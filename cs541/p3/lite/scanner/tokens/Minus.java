package lite.scanner.tokens;

import lite.parse.Symbols;

public class Minus extends Token
{
    public int TOKEN_TYPE = Symbols.MINUS;

    public Minus(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "-";
    }

    public int getTokenType()
    {
        return Symbols.MINUS;
    }
}
