package lite.scanner.tokens;

import lite.parse.Symbols;

public class IntLit extends Token
{
    public int TOKEN_TYPE = Symbols.INT_LIT;

    public int intValue;

    public IntLit(int val, int line, int col)
    {
        super(line, col);
        intValue = val; 
    }

    public String toString()
    {
        return new StringBuffer("Integer literal (").append(intValue)
                                                    .append(")")
                                                    .toString();
    }

    public int getTokenType()
    {
        return Symbols.INT_LIT;
    }
}
