package lite.scanner;

// This class is used to track line and column numbers
// Feel free to change to extend it
class Pos
{
    static int linenum = 1; // The line number current token was scanned on. 
    static int colnum  = 1; // The column number current token began at.
    static int line    = 1; // The line number after scanning current token.
    static int col     = 1; // The column number after scanning current token. 

    // set starting position for current token
    static void setpos()
    { 
        linenum = line;
        colnum = col;
    }
}
