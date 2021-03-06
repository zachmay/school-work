import java.io.*;

class P2 {
    public static void main(String args[]) throws java.io.IOException {
        if (args.length != 1) {
            System.out.println("Error: Input file must be named on command line.");
            System.exit(-1);
        }

        java.io.FileInputStream yyin = null;

        try {
            yyin = new java.io.FileInputStream(args[0]);
        } catch (FileNotFoundException notFound){
            System.out.println ("Error: unable to open input file.");
            System.exit(-1);
        }

        // lex is a JLex-generated scanner that reads from yyin
        final Yylex lex = new Yylex(yyin);	

        System.out.println ("Begin test of CSX scanner.");

        /**********************************************
          You should enter code here that thoroughly tests your scanner.

          Be sure to test extreme cases, like very long symbols or lines,
          invalid tokens, unrepresentable integers, and invalid strings.

          The following is only a starting point.
         **********************************************/

        Symbol token = null;

        try {
            token = lex.yylex();
        } catch ( Error e ) {
            System.out.println("I DIED!");
            return;
        }

        while ( token.sym != SymbolTypes.EOF) {
            System.out.print(token.value.linenum + ":" + token.value.colnum + "\t");
            System.out.println(token.value.toString());

            /*
            switch (token.sym) {
                case sym.INTLIT:
                    System.out.println("\tinteger literal(" +
                            ((CSXIntLitToken) token.value).intValue + ")");
                    break;
                case sym.LBRACE:
                    System.out.println("\t}");
                    break;
                case sym.PLUS:
                    System.out.println("\t+");
                    break;
                case sym.NOTEQ:
                    System.out.println("\t!=");
                    break;
                default:
                    System.out.println("unrecognized token type: " + token.value);
            } // switch(token.sym)
            */
            try {
                token = lex.yylex(); // get next token.
            } catch ( Error e ) {
                System.out.println("I DIED");
                System.out.println(e.toString());
            }
        } // not at EOF
        System.out.println("End test of CSX scanner.");
    } // main()
} // class P2
