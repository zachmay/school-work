package lite.scanner.tokens;

import lite.parse.Symbols;

public class Identifier extends Token
{
    public int TOKEN_TYPE = Symbols.IDENTIFIER;

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

    public int getTokenType()
    {
        return Symbols.IDENTIFIER;
    }
}
