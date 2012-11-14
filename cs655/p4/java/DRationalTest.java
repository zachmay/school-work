public class DRationalTest extends Test
{
    public static void run()
    {
        DRational halfMeter = new DRational( new Rational(1, 2)
                                           , Dimension.length());
        DRational oneFoot   = DRational.foot();
        DRational oneHour   = DRational.hour();
        DRational oneSecond = DRational.second();

        System.out.println("Testing dimensioned rational creation methods...");
        assertEquals(halfMeter.getDimension(), Dimension.length());
        assertEquals(halfMeter.getMagnitude(), new Rational(1, 2));
        assertEquals(oneFoot.getDimension(), Dimension.length());
        assertEquals(oneFoot.getMagnitude(), new Rational(3048, 10000));
        assertEquals(oneHour.getDimension(), Dimension.time());
        assertEquals(oneHour.getMagnitude(), new Rational(3600));

        System.out.println("Testing dimensioned rational addition...");
        DRational oneFootPlusHalfMeter
            = new DRational(new Rational(8048, 10000), Dimension.length());
        assertEquals(oneFoot.add(halfMeter), oneFootPlusHalfMeter);
            
        boolean failed = false; 
        try
        {
            DRational r = oneFoot.add(oneHour);
        }
        catch ( IllegalArgumentException e )
        {
            failed = true;
        }
        if ( !failed )
        {
            System.out.println("Expected failure adding 1 ft with 1 hr.");
            Thread.dumpStack();
        }

        System.out.println("Testing dimensioned rational subtraction...");
        DRational oneFootMinusHalfMeter
            = new DRational(new Rational(-1952, 10000), Dimension.length());
        assertEquals(oneFoot.subtract(halfMeter), oneFootMinusHalfMeter);

        failed = false; 
        try
        {
            DRational r = oneFoot.subtract(oneHour);
        }
        catch ( IllegalArgumentException e )
        {
            failed = true;
        }
        if ( !failed )
        {
            System.out.println("Expected failure on one foot minus one hour.");
            Thread.dumpStack();
        }

        System.out.println("Testing dimensioned rational multiplication...");
        DRational oneFootTimesHalfMeter
            = new DRational( new Rational(1524, 10000)
                           , Dimension.length().multiply(Dimension.length()));
        DRational oneFootTimesOneHour
            = new DRational( new Rational(109728, 100)
                           , Dimension.length().multiply(Dimension.time()));
        assertEquals(oneFoot.multiply(halfMeter), oneFootTimesHalfMeter);
        assertEquals(oneFoot.multiply(oneHour), oneFootTimesOneHour);

        System.out.println("Testing dimensioned rational division...");
        DRational oneFootDivHalfMeter
            = new DRational( new Rational(6096, 10000)
                           , Dimension.scalar());
        DRational oneFootDivOneHour
            = new DRational( new Rational(127, 1500000)
                           , Dimension.velocity());
        assertEquals(oneFoot.div(halfMeter), oneFootDivHalfMeter);
        assertEquals(oneFoot.div(oneHour), oneFootDivOneHour);

        // DRational relational operators.
        System.out.println("Testing dimensioned rational relational operators...");
        
        assertEquals(oneFoot.equals(oneFoot), true);
        assertEquals(oneFoot.equals(
                    DRational.scalar(new Rational(3048, 10000)).multiply(DRational.meter())),
                    true);
        assertEquals(oneFoot.lt(halfMeter), true);
        assertEquals(oneFoot.lte(halfMeter), true);
        assertEquals(oneFoot.gt(halfMeter), false);
        assertEquals(oneFoot.gte(halfMeter), false);
        assertEquals(oneHour.gt(oneSecond), true);
        assertEquals(oneHour.gte(oneSecond), true);
        assertEquals(oneHour.lt(oneSecond), false);
        assertEquals(oneHour.lt(oneSecond), false);

        failed = false;
        try
        {
            oneFoot.lt(oneHour);
        }
        catch ( IllegalArgumentException e )
        {
            failed = true;
        }
        if ( !failed )
        {
            System.out.println("Expected failure on one foot < one hour.");
            Thread.dumpStack();
        }

        failed = false;
        try
        {
            oneFoot.lte(oneHour);
        }
        catch ( IllegalArgumentException e )
        {
            failed = true;
        }
        if ( !failed )
        {
            System.out.println("Expected failure on one foot <= one hour.");
            Thread.dumpStack();
        }

        failed = false;
        try
        {
            oneFoot.gt(oneHour);
        }
        catch ( IllegalArgumentException e )
        {
            failed = true;
        }
        if ( !failed )
        {
            System.out.println("Expected failure on one foot > one hour.");
            Thread.dumpStack();
        }

        failed = false;
        try
        {
            oneFoot.gte(oneHour);
        }
        catch ( IllegalArgumentException e )
        {
            failed = true;
        }
        if ( !failed )
        {
            System.out.println("Expected failure on one foot >= one hour.");
            Thread.dumpStack();
        }
    }
}
