package net.sector42.cs541.tokens;

public class StringLit extends Token
{
    public static final int TOKEN_TYPE = 8;

    String stringText; // Full text of string literal,
                       // including quotes & escapes.

    public StringLit(String text, int line, int col)
    {
        super(line, col);
        stringText = text;
    }

    public String toString()
    {
        return new StringBuffer("String literal (").append(stringText)
                                                   .append(")")
                                                   .toString();
    }
}
