package lite.scanner.tokens;

import lite.parse.Symbols;

public class LeftBracket extends Token
{
    public int TOKEN_TYPE = Symbols.LEFT_BRACKET;

    public LeftBracket(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "[";
    }

    public int getTokenType()
    {
        return Symbols.LEFT_BRACKET;
    }
}
