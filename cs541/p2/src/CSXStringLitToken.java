class CSXStringLitToken extends CSXToken {
    String stringText; // Full text of string literal,
                       // including quotes & escapes.
    CSXStringLitToken(String text, int line, int col) {
        super(line, col);
        stringText = text;
    }
    public String toString() {
        return new StringBuffer("String literal (\"").append(stringText)
                                                     .append(")")
                                                     .toString();
    }
}
