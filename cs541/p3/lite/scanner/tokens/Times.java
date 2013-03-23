package lite.scanner.tokens;

import lite.parse.Symbols;

public class Times extends Token
{
    public int TOKEN_TYPE = Symbols.TIMES;

    public Times(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "*";
    }

    public int getTokenType()
    {
        return Symbols.TIMES;
    }
}
