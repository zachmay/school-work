package lite.scanner.tokens;

import lite.parse.Symbols;

public class RightParen extends Token
{
    public int TOKEN_TYPE = Symbols.RIGHT_PAREN;

    public RightParen(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return ")";
    }

    public int getTokenType()
    {
        return Symbols.RIGHT_PAREN;
    }
}
