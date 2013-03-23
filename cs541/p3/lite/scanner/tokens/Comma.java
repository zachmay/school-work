package lite.scanner.tokens;

import lite.parse.Symbols;

public class Comma extends Token
{
    public int TOKEN_TYPE = Symbols.COMMA;

    public Comma(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return ",";
    }

    public int getTokenType()
    {
        return Symbols.COMMA;
    }
}
