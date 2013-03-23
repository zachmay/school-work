package lite.scanner.tokens;

import lite.parse.Symbols;

public class Assignment extends Token
{
    public int TOKEN_TYPE = Symbols.ASSIGN;

    public Assignment(int line, int col)
    {
        super(line, col);
    }

    public String toString()
    {
        return "=";
    }

    public int getTokenType()
    {
        return Symbols.ASSIGN;
    }
}
