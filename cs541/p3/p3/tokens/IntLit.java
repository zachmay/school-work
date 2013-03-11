package p3.tokens;

public class IntLit extends Token
{
    public static final int TOKEN_TYPE = 7;

    int intValue;

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
}
