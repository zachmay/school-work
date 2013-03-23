package lite.scanner.tokens;

import lite.parse.Symbols;

public class ErrorToken extends Token
{
    public int TOKEN_TYPE = Symbols.error;

    String message;

    public ErrorToken(String msg, int line, int col)
    {
        super(line, col);
        message = msg;
    }

    public String toString()
    {
        return new StringBuffer("**ERROR: ").append(message)
                                            .toString();
    }

    public int getTokenType()
    {
        return Symbols.error;
    }
}

