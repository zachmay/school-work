/* Zachary May
 * CS 541
 * Program 1
 *
 * Modified from provided starting point.
 */
import java.io.*;
import java.util.Hashtable;

/*
 * Class SymbolTable
 *
 * Represents a block-scoped symbol table with methods
 * for insertion, lookup, scope management, and debug
 * information.
 */
class SymbolTable
{
    // The current innermost name scope.
    NameScope currentScope = null;

    // Constructor: Open an initial name scope.
    public SymbolTable() {
        openScope();
    }

    // Open a new name scope.
    // Ensures that the new scope has the current innermost scope as
    // its outer name scope (for global lookups, etc.)
    public void openScope() {
        NameScope newScope = new NameScope();
        newScope.setOuterScope(currentScope);
        currentScope = newScope;
    }

    // Close the innermost name scope.
    // Uses the current scope's outer scope for the new innermost scope.
    // Throws EmptySTException if there are no open name scopes.
    public void closeScope() throws EmptySTException {
        if ( currentScope == null ) {
            throw new EmptySTException();
        } else {
            currentScope = currentScope.getOuterScope();
        }
    }

    // Insert a symbol into the innermost name scope.
    // Delegates to the innermost name scope's insert method.
    // Throws EmptySTException is there are no open name scopes.
    // Throws DuplicateException (bubbled up from NameScope::insert) if symbol
    // name already exists.
    public void insert(Symb s) throws EmptySTException, DuplicateException {
        if ( currentScope == null ) {
            throw new EmptySTException();
        }
        currentScope.insert(s);
    }

    // Look up a symbol identifier in the innermost scope.
    // Delegates to the innermost name scope's localLookup method.
    // Returns null if there are no open name scopes.
    public Symb localLookup(String s) {
        if ( currentScope == null ) {
            return null;
        } else {
            return currentScope.localLookup(s);
        }
    }

    // Look up a symbol identifier in any open scoe.
    // Delegates to the innermost name scoe's globalLookup metho,
    // which follows outerScope links out to the outermost scope
    // if necessary.
    // Returns null if there are no open name scopes.
    public Symb globalLookup(String s) {
        if ( currentScope == null ) {
            return null;
        } else {
            return currentScope.globalLookup(s);
        }
    }

    // Return a string representation of the symbol table.
    public String toString() {
        return (currentScope == null ? "" : currentScope.toString());
    }

    // Dump the string representation of the symbol table to a 
    // given PrintStream.
    void dump(PrintStream ps) {
        ps.println(this.toString());
    }
} // class SymbolTable
