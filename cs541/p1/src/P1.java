import java.io.*;
/* Zachary May
 * CS 541
 * Program 1
 *
 * Modified from provided starting point.
 *
 * Class P1
 *
 * Test driver for SymbolTable.
 */
class P1 {
    // A line-buffered input reader.
    private static BufferedReader inputReader
        = new BufferedReader(new InputStreamReader(System.in));

    // The symbol table we will manipulate in this test driver.
    private static SymbolTable symbolTable = new SymbolTable();

    public static void main(String args[]) throws IOException {
        doUsage();
        boolean shouldContinue = true;
        while ( shouldContinue ) {
            char command = readCommand(); 
            switch ( command ) {
                case 'o':
                    doOpen(); break;
                case 'c':
                    doClose(); break;
                case 'd':
                    doDump(); break;
                case 'i':
                    doInsert(); break;
                case 'l':
                    doLocalLookup(); break;
                case 'g':
                    doGlobalLookup(); break;
                case 'q':
                    shouldContinue = false; break;
            }
        }
        System.out.println("Testing done");
    } // main

    // Given a prompt string, display the prompt and read a line of
    // input from our inputReader, returning the result.
    private static String readString(String prompt) throws IOException {
        System.out.print(prompt);
        return inputReader.readLine();
    }

    // Read a driver command from input. Normalize the command
    // to the first character of the input in lower case. If
    // no input was received, just return a null character.
    private static char readCommand() throws IOException
    {
        String in = readString("").toLowerCase();
        return in.length() == 0 ? '\0' : in.charAt(0);
    }

    // Command Implementation: Open new name scope.
    private static void doOpen() {
        symbolTable.openScope();
        System.out.println("New scope opened.");
    }

    // Command Implementation: Close top name scope.
    private static void doClose() {
        try {
            symbolTable.closeScope();
            System.out.println("Top scope closed.");
        } catch ( EmptySTException e ) {
            System.out.println("Close failed. No open name scopes.");
        }
    }

    // Command Implementation: Dump symbol table contents.
    private static void doDump() {
        System.out.println("Contents of symbol table:");
        symbolTable.dump(System.out);
    }

    // Command Implementation: Insert new symbol.
    private static void doInsert() throws IOException {
        String identifier = readString("");
        int value = Integer.parseInt(readString(""));
        Symb s = new TestSym(identifier, value);
        try {
            symbolTable.insert(s);
            System.out.println(s.toString() + " entered into symbol table.");
        } catch ( EmptySTException e ) {
            System.out.println("Insert failed. No open name scopes.");
        } catch ( DuplicateException e ) {
            System.out.println(identifier + " already entered into top scope.");
        }
    }

    // Command Implementation: Local lookup.
    private static void doLocalLookup() throws IOException {
        String identifier = readString("");
        Symb s = symbolTable.localLookup(identifier);
        if ( s == null ) {
            System.out.println(identifier + " not found in top scope.");
        } else {
            System.out.println(s.toString() + " found in top scope.");
        }
    }

    // Command Implementation: Global lookup.
    private static void doGlobalLookup() throws IOException {
        String identifier = readString("");
        Symb s = symbolTable.globalLookup(identifier);
        if ( s == null ) {
            System.out.println(identifier + " not found in symbol table.");
        } else {
            System.out.println(s.toString() + " found in symbol table.");
        }
    }

    // Display usage message.
    private static void doUsage() {
        System.out.println(
            "Project 1 test driver. Enter any of the following commands:\n"+
            "  (Command prefixes are allowed)\n"+
            "\tOpen (a new scope)\n"+
            "\tClose (innermost current scope)\n"+
            "\tQuit (test driver)\n"+
            "\tDump (contents of symbol table)\n"+
            "\tInsert (symbol,integer pair into symbol table)\n"+
            "\tLookup (lookup symbol in top scope)\n"+
            "\tGlobal (global lookup of symbol in symbol table)\n\n");
    }


} // class P1
