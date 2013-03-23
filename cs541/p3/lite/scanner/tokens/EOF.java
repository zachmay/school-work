package lite.scanner.tokens;

import lite.parse.Symbols;

public class EOF extends Token
{
    public int TOKEN_TYPE = Symbols.EOF;

    public EOF(int line, int col)
    {
        super(line, col);
    }

    public boolean isEOF()
    {
        return true;
    }

    public String toString()
    {
        return "EOF";
    }

    public int getTokenType()
    {
        return Symbols.EOF;
    }
}
