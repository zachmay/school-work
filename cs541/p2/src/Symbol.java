class Symbol { 
    public int sym;
    public CSXToken value;

    public Symbol(int tokenType, CSXToken theToken) {
        sym = tokenType;
        value = theToken;
    }

    public static Symbol create(int tokenType, int line, int col) {
        return new Symbol(tokenType, new CSXToken(line, col));
    }

    public static Symbol create(int tokenType) {
        return new Symbol(tokenType, new CSXToken(Pos.linenum, Pos.colnum));
    }

    public static Symbol createCharLiteral(char charVal) {
        return new Symbol(SymbolTypes.CHARLIT,
                          new CSXCharLitToken(charVal,
                                              Pos.linenum,
                                              Pos.colnum));
    }

    public static Symbol createError(String message) {
        return new Symbol(SymbolTypes.error,
                          new CSXErrorToken(message, Pos.linenum, Pos.colnum));
    }

    public static Symbol createIdentifier(String identifierText) {
        return new Symbol(SymbolTypes.IDENTIFIER,
                          new CSXIdentifierToken(identifierText.toLowerCase(),
                                                 Pos.linenum,
                                                 Pos.colnum));
    }

    public static Symbol createIntegerLiteral(int intVal) {
        return new Symbol(SymbolTypes.INTLIT,
                          new CSXIntLitToken(intVal, Pos.linenum, Pos.colnum));
    }

    public static Symbol createStringLiteral(String stringVal) {
        return new Symbol(SymbolTypes.STRLIT,
                          new CSXStringLitToken(stringVal,
                                                Pos.linenum,
                                                Pos.colnum));
    }

    public String toString() {
        return new StringBuffer("Symbol(").append(SymbolTypes.describe(sym))
                                          .append("): ")
                                          .append(value.toString())
                                          .toString();
    }
}
