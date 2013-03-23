package lite;

import java.io.*;
import java_cup.runtime.*;
import lite.parse.Parser;
import lite.scanner.LiteScanner;
import lite.scanner.tokens.Token;
import lite.ast.*;

class P3
{
    public static void main(String args[]) throws java.io.IOException
    {
        if ( args.length != 1 )
        {
            System.out.println("Error: Input file must be named on command line." );
            System.exit(-1);
        }

        java.io.FileInputStream yyin = null;

        try
        {
            yyin = new java.io.FileInputStream(args[0]);
        }
        catch ( FileNotFoundException notFound )
        {
            System.out.println ("Error: unable to open input file.");
            System.exit(-1);
        }

        Scanner theScanner = new LiteScanner(yyin);

        /*
        try
        {
            do
            {
                java_cup.runtime.Symbol s = theScanner.next_token();
                Token v = (Token)s.value;
                if ( s.sym == 0 ) break;
                System.out.print(s.sym);
                System.out.print(" ");
                System.out.println(s.value.toString());
            } while ( true );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
        */

        final Parser theParser = new Parser();
        theParser.setScanner(theScanner);
        Symbol root = null;

        try
        {
            //root = theParser.debug_parse();
            root = theParser.parse(); // do the parse
            System.out.println ("CSX program parsed correctly.");
        }
        catch (Exception e)
        {
            System.out.println ("Compilation terminated due to syntax errors.");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Here is its unparsing:");
        System.out.println(((ProgramNode)root.value).unparse(0));
    } // main

} // class P3
