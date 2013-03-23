package lite.scanner.tokens;

import lite.parse.Symbols;

public class RightBracket extends Token
{
    public int TOKEN_TYPE = Symbols.RIGHT_BRACKET;

    public RightBracket(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "]";
    }

    public int getTokenType()
    {
        return Symbols.RIGHT_BRACKET;
    }
}
