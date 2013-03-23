package lite.scanner.tokens;

import lite.parse.Symbols;

public class LeftParen extends Token
{
    public int TOKEN_TYPE = Symbols.LEFT_PAREN;

    public LeftParen(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "(";
    }

    public int getTokenType()
    {
        return Symbols.LEFT_PAREN;
    }
}
