class CSXErrorToken extends CSXToken {
    String message;
    CSXErrorToken(String msg, int line, int col) {
        super(line, col);
        message = msg;
    }
    public String toString() {
        return new StringBuffer("ErrorToken(").append(message)
                                         .append(", ")
                                         .append(linenum)
                                         .append(", ")
                                         .append(colnum)
                                         .append(")<<")
                                         .toString();
    }
}

