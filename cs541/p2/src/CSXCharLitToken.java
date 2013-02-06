class CSXCharLitToken extends CSXToken {
    char charValue;
    CSXCharLitToken(char val, int line, int col) {
        super(line, col);
        charValue = val; 
    }
    public String toString() {
        return new StringBuffer("Character(").append(charValue)
                                             .append(", ")
                                             .append(linenum)
                                             .append(", ")
                                             .append(colnum)
                                             .append(")")
                                             .toString();
    }
}
