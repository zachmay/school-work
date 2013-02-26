package net.sector42.cs541;

import java.io.*;

class P2
{
    public static void main(String args[]) throws java.io.IOException
    {
        // Handle command-line arguments.
        if (args.length != 1)
        {
            System.out.println("Error: Input file must be named on command line.");
            System.exit(-1);
        }

        // Attempt to open specified file for reading.
        java.io.FileInputStream yyin = null;

        try
        {
            yyin = new java.io.FileInputStream(args[0]);
        }
        catch (FileNotFoundException notFound)
        {
            System.out.println ("Error: unable to open input file.");
            System.exit(-1);
        }

        // Instantiate our generated scanner.
        final Yylex lex = new Yylex(yyin);	

        System.out.println ("Begin test of CSX scanner.");

        Symbol token = null;

        // Read tokens until we reach the EOF token
        // Output the location the token was found, along
        // with a representation of the token itself.
        do
        {
            try
            {
                token = lex.yylex(); // Get next token.

                if ( !token.value.isEOF() )
                {
                    String location = new StringBuffer("")
                                               .append(token.value.getLine())
                                               .append(":")
                                               .append(token.value.getColumn())
                                               .toString();

                    System.out.printf("%-10s", location);
                    System.out.println(token.value.toString());
                }
            }
            catch ( Error e )
            {
                System.out.println("**ERROR");
                System.out.println(e.toString());
            }
        }
        while ( !token.value.isEOF() );

        System.out.println("End test of CSX scanner.");
    } // main()
} // class P2
