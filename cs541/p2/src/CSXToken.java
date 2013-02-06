class CSXToken {
    int linenum;
    int colnum;
    CSXToken(int line, int col) {
        linenum = line;
        colnum = col;
    }
    public String toString() {
        return new StringBuffer("Token(").append(linenum)
                                         .append(", ")
                                         .append(colnum)
                                         .append(")")
                                         .toString();
    }
}
