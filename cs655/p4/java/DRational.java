public class DRational
{
    /**********************
     * Instance variables.
     **********************/
    private Rational magnitude;
    private Dimension dimension;

    /****************
     * Constructors.
     ****************/
    public DRational(Rational mag, Dimension dim)
    {
        this.setMagnitude(mag);
        this.setDimension(dim);
    }

    public DRational(int mag, Dimension dim)
    {
        this.setMagnitude(new Rational(mag));
        this.setDimension(dim);
    }

    public DRational(Rational mag)
    {
        this(mag, Dimension.scalar());
    }

    public DRational()
    {
        this(0, Dimension.scalar());
    }

    /****************************************************
     * Some built-in 'constructors' for common measures. 
     ****************************************************/
    public static DRational scalar(Rational r)
    {
        return new DRational(r);
    }

    public static DRational scalar(int i)
    {
        return new DRational(new Rational(i));
    }

    public static DRational meter()
    {
        return new DRational(1, Dimension.length());
    }

    public static DRational foot()
    {
        return scalar(new Rational(3048, 10000)).multiply(meter());
    }

    public static DRational yard()
    {
        return scalar(3).multiply(foot());
    }

    public static DRational second()
    {
        return new DRational(1, Dimension.time());
    }

    public static DRational minute()
    {
        return scalar(60).multiply(second());
    }

    public static DRational hour()
    {
        return scalar(60).multiply(minute());
    }

    public static DRational kilogram()
    {
        return new DRational(1, Dimension.mass());
    }

    public static DRational gram()
    {
        return scalar(1000).multiply(kilogram());
    }

    /***********
     * Display.
     ***********/
    public String toString()
    {
        return getMagnitude().toString() + " " + getDimension().toString();
    }

    /*********************************
     * Dimension compatibility check.
     *********************************/
    public void dimensionSafe(DRational d)
    {
        if ( !this.getDimension().equals(d.getDimension()) )
        {
            throw new IllegalArgumentException("Incompatible dimensions.");
        }
    }

    /**************
     * Operations.
     **************/
    public DRational add(DRational d)
    {
        this.dimensionSafe(d);

        return new DRational( this.getMagnitude().add(d.getMagnitude())
                            , this.getDimension() );
    }

    public DRational subtract(DRational d)
    {
        this.dimensionSafe(d);

        return new DRational( this.getMagnitude().subtract(d.getMagnitude())
                            , this.getDimension() );
    }

    public DRational multiply(DRational d)
    {
        return new DRational( this.getMagnitude().multiply(d.getMagnitude())
                            , this.getDimension().multiply(d.getDimension()) );
    }

    public DRational div(DRational d)
    {
        return new DRational( this.getMagnitude().div(d.getMagnitude())
                            , this.getDimension().div(d.getDimension()) );
    }

    public boolean equals(Object other)
    {
        if ( other instanceof DRational )
        {
            DRational d = (DRational) other;
            return this.getMagnitude().equals(d.getMagnitude())
                && this.getDimension().equals(d.getDimension());
        }

        return false;
    }

    /*******************
     * Getters/Setters.
     *******************/
    public Rational getMagnitude()
    {
        return magnitude;
    }

    public DRational setMagnitude(Rational r)
    {
        magnitude = r;
        return this;
    }

    public Dimension getDimension()
    {
        return dimension;
    }

    public DRational setDimension(Dimension d)
    {
        dimension = d;
        return this;
    }
}
