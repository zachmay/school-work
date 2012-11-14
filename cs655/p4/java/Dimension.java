public class Dimension
{
    /*********************
     * Instance variables
     *********************/
    private int length = 0;
    private int mass   = 0;
    private int time   = 0;

    /***************
     * Constructors
     ***************/
    public Dimension(int length, int mass, int time)
    {
        this.setLength(length);
        this.setMass(mass);
        this.setTime(time);
    }

    public Dimension()
    {
        this.setLength(0);
        this.setMass(0);
        this.setTime(0);
    }

    /********************************************************
     * Static helper methods for creating common dimensions.
     ********************************************************/
    public static Dimension scalar()
    {
        return new Dimension();
    }

    public static Dimension length()
    {
        return new Dimension(1, 0, 0);
    }

    public static Dimension mass()
    {
        return new Dimension(0, 1, 0);
    }

    public static Dimension time()
    {
        return new Dimension(0, 0, 1);
    }

    public static Dimension velocity()
    {
        return Dimension.length().div(Dimension.time());
    }

    public static Dimension acceleration()
    {
        return Dimension.velocity().div(Dimension.time());
    }

    public static Dimension area()
    {
        return Dimension.length().multiply(Dimension.length());
    }

    public static Dimension volume()
    {
        return Dimension.length().multiply(Dimension.area());
    }
    
    public static Dimension density()
    {
        return Dimension.mass().div(Dimension.volume());
    }

    /***********
     * Display.
     ***********/
    public String toString()
    {
        return "(" + (new Integer(this.getLength()).toString()) + 
               "," + (new Integer(this.getMass()).toString()) + 
               "," + (new Integer(this.getTime()).toString()) + ")";

    }

    /************************
     * Dimension operations.
     ************************/
    public Dimension invert()
    {
        return new Dimension( -this.getLength()
                            , -this.getMass()
                            , -this.getTime() );
    }

    public Dimension multiply(Dimension d)
    {
        return new Dimension( this.getLength() + d.getLength()
                            , this.getMass() + d.getMass()
                            , this.getTime() + d.getTime() );
    } 

    public Dimension div(Dimension d)
    {
        return this.multiply(d.invert());
    }

    public boolean equals(Object other)
    {
        if ( other instanceof Dimension )
        {
            Dimension d = (Dimension) other;
            return this.getLength() == d.getLength()
                && this.getMass()   == d.getMass()
                && this.getTime()   == d.getTime();
        }

        return false;
    }

    /********************************************
     * Getters/setters for dimension components.
     ********************************************/
    public int getLength()
    {
        return length;
    }

    public Dimension setLength(int l)
    {
        length = l;
        return this;
    }

    public int getMass()
    {
        return mass;
    }

    public Dimension setMass(int m)
    {
        mass = m;
        return this;
    }

    public int getTime()
    {
        return time;
    }

    public Dimension setTime(int t)
    {
        time = t;
        return this;
    }
}

