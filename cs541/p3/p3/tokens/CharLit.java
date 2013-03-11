package p3.tokens;

public class CharLit extends Token
{
    public static final int TOKEN_TYPE = 9;

    String charValue;

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
}
