package lite.scanner.tokens;

import lite.parse.Symbols;

public class CharLit extends Token
{
    public int TOKEN_TYPE = Symbols.CHAR_LIT;

    public String charValue;

    public CharLit(String val, int line, int col)
    {
        super(line, col);
        charValue = val; 
    }

    public String toString() {
        return new StringBuffer("Character Literal (").append(charValue)
                                                      .append(")")
                                                      .toString();
    }

    public int getTokenType()
    {
        return Symbols.CHAR_LIT;
    }
}
