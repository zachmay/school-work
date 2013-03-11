package p3.tokens;

public class Identifier extends Token
{
    public static final int TOKEN_TYPE = 10;

    public String identifierText;

    public Identifier(String text, int line, int col)
    {
        super(line, col);
        identifierText = text;
    }

    public String toString()
    {
        return new StringBuffer("Identifier (").append(identifierText)
                                               .append(")")
                                               .toString();
    }
}
