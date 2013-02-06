/* Zachary May
 * CS 541
 * Program 1
 */
import java.util.Hashtable;

/* Class NameScope
 *
 * Represents a single open name scope in a SymbolTable.
 */
class NameScope
{
    // The hashtable mapping identifiers (Strings) to Symb objects.
    Hashtable<String, Symb> nameTable = new Hashtable<String, Symb>();

    // A reference to this name scope's immediate outer scope.
    NameScope outerScope = null;
        
    // Getter/Setter for outer scope reference.
    public NameScope getOuterScope() {
        return outerScope;
    }

    public void setOuterScope(NameScope os) {
        outerScope = os;
    }

    // Insert a symbol into this name scope.
    // Throws DuplicateException if the identifier already exists
    // in this name scope.
    public void insert(Symb s) throws DuplicateException {
        if ( this.localLookup(s.getName()) == null ) {
            this.nameTable.put(s.getName(), s);
        } else {
            throw new DuplicateException();
        }
    }

    // Perform a local lookup of a given identifier in
    // this name scope.
    // Returns null if not found.
    public Symb localLookup(String s) {
        return this.nameTable.get(s.toLowerCase());
    }

    // Perform a global lookup of a given identifier in
    // this name scope, or any outer name scope.
    // Performs global lookups up the chain of outer scopes
    // if possible.
    public Symb globalLookup(String s) {
        Symb symbol = this.localLookup(s);
        if ( symbol != null ) {
            return symbol;
        } else if ( this.outerScope == null ) {
            return null;
        } else {
            return this.outerScope.globalLookup(s);
        }
    }

    // Return a string representation of this name scope and,
    // recursively, any outer name scopes.
    public String toString() {
        String s = "{";
        boolean first = true;
        for ( String identifier : this.nameTable.keySet() ) {
            if ( !first ) {
                s = s + ", ";
            }
            first = false;
            s = s + identifier + "=" + this.nameTable.get(identifier).toString();
        }
        s = s + "}\n";
        return s + (this.outerScope == null ? "" : this.outerScope.toString());
    }
}
