class CSXIdentifierToken extends CSXToken {
    String identifierText;
    CSXIdentifierToken(String text, int line, int col) {
        super(line, col);
        identifierText = text;
    }
    public String toString() {
        return new StringBuffer("Identifier (").append(identifierText)
                                               .append(")")
                                               .toString();
    }
}
