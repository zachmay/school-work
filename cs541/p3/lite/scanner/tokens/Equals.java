package lite.scanner.tokens;

import lite.parse.Symbols;

public class Equals extends Token
{
    public int TOKEN_TYPE = Symbols.EQUALS;

    public Equals(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "==";
    }

    public int getTokenType()
    {
        return Symbols.EQUALS;
    }
}
