package p3.tokens;

public class ErrorToken extends Token
{
    public static final int TOKEN_TYPE = 1;

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
}

