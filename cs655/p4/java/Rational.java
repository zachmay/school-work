public class Rational
{
    /**********************
     * Instance variables.
     **********************/
    private int num;
    private int den;

    /***************
     * Constructors
     ***************/
    public Rational(int num)
    {
        this(num, 1);
    }

    public Rational()
    {
        this(0, 1);
    }

    public Rational(int num, int den)
    {
        // Check for division by zero.
        if ( den == 0 )
        {
            throw new IllegalArgumentException(
                    "Rational denominator cannot be 0.");
        }

        // Normalize negative signs.
        int n = num;
        int d = den;

        if ( d < 0 )
        {
            n = -n;
            d = -d;
        }

        // Put numerator and denominator in lowest terms.
        int gcd = Rational.gcd(Math.abs(n), Math.abs(d));
        n = n / gcd;
        d = d / gcd;

        this.setNum(n);
        this.setDen(d);
    }

    /*******************
     * Utility methods.
     *******************/
    public static int gcd(int a, int b)
    {
        if ( a == 0 ) return b;
        
        while ( b != 0 )
        {
            if ( a > b )
            {
                a = a - b;
            }
            else
            {
                b = b - a;
            }
        }

        return a;
    }

    /***********
     * Display.
     ***********/
    public String toString()
    {
        return ( new Integer(num).toString()) + "/"
               + (new Integer(den).toString());
    }

    /**************
     * Operations.
     **************/
    public Rational add(Rational r)
    {
        int newDen = this.getDen() * r.getDen();
        int newNum = this.getNum() * r.getDen() + r.getNum() * this.getDen();

        return new Rational(newNum, newDen);
    }

    public Rational subtract(Rational r)
    {
        return this.add(r.negate());
    }

    public Rational multiply(Rational r)
    {
        return new Rational( this.getNum() * r.getNum()
                           , this.getDen() * r.getDen() );
    }

    public Rational div(Rational r)
    {
        return this.multiply(r.reciprocal());
    }

    public Rational negate()
    {
        return new Rational(-this.getNum(), this.getDen());
    }

    public Rational reciprocal()
    {
        return new Rational(this.getDen(), this.getNum());
    }

    /************************
     * Relational operators.
     ************************/
    public boolean equals(Object other)
    {
        if ( other instanceof Rational )
        {
            Rational r = (Rational) other;

            return this.getNum() == r.getNum()
                && this.getDen() == r.getDen();
        }

        return false;
    }

    public boolean lt(Rational r)
    {
        return this.getNum() * r.getDen() < r.getNum() * this.getDen();
    }

    public boolean lte(Rational r)
    {
        return this.lt(r) || this.equals(r);
    }

    public boolean gt(Rational r)
    {
        return this.getNum() * r.getDen() > r.getNum() * this.getDen();
    }

    public boolean gte(Rational r)
    {
        return this.gt(r) || this.equals(r);
    }

    /*******************
     * Getters/Setters.
     *******************/
    public int getNum()
    {
        return num;
    }

    public Rational setNum(int numerator)
    {
        num = numerator;
        return this;
    }

    public int getDen()
    {
        return den;
    }

    public Rational setDen(int denominator)
    {
        den = denominator;
        return this;
    }
}
