class CSXIntLitToken extends CSXToken {
    int intValue;
    CSXIntLitToken(int val, int line, int col) {
        super(line, col);
        intValue = val; 
    }
    public String toString() {
        return new StringBuffer("Integer literal (").append(intValue)
                                                    .append(colnum)
                                                    .append(")")
                                                    .toString();
    }
}
