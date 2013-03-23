package lite.scanner.tokens;

import lite.parse.Symbols;

public class StringLit extends Token
{
    public int TOKEN_TYPE = Symbols.STRING_LIT;

    public String stringValue; // Full text of string literal,
                               // including quotes & escapes.

    public StringLit(String text, int line, int col)
    {
        super(line, col);
        stringValue = text;
    }

    public String toString()
    {
        return new StringBuffer("String literal (").append(stringValue)
                                                   .append(")")
                                                   .toString();
    }

    public int getTokenType()
    {
        return Symbols.STRING_LIT;
    }
}
