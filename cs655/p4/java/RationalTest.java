public class RationalTest extends Test
{
    //
    // Test Rational number creation and operations.
    //
    public static void run()
    {
        System.out.println("Testing rational creation...");
        Rational zero           = new Rational();
        Rational three          = new Rational(3);
        Rational oneThird       = new Rational(1, 3);
        Rational zeroSimplified = new Rational(0, 1000);
        Rational simplified1    = new Rational(20, 30);
        Rational simplified2    = new Rational(1200, 800);
        Rational negSimplified1 = new Rational(1, -3);
        Rational negSimplified2 = new Rational(-2, 4);
        Rational negSimplified3 = new Rational(2, -4);
        Rational negSimplified4 = new Rational(-1, -2);
        Rational negSimplified5 = new Rational(-2, -4);

        assertEquals(zero.getNum(),           0);
        assertEquals(zero.getDen(),           1);
        assertEquals(three.getNum(),          3);
        assertEquals(three.getDen(),          1);
        assertEquals(oneThird.getNum(),       1);
        assertEquals(oneThird.getDen(),       3);
        assertEquals(zeroSimplified.getNum(), 0);
        assertEquals(zeroSimplified.getDen(), 1);
        assertEquals(simplified1.getNum(),    2);
        assertEquals(simplified1.getDen(),    3);
        assertEquals(simplified2.getNum(),    3);
        assertEquals(simplified2.getDen(),    2);
        assertEquals(negSimplified1.getNum(), -1);
        assertEquals(negSimplified1.getDen(), 3);
        assertEquals(negSimplified2.getNum(), -1);
        assertEquals(negSimplified2.getDen(), 2);
        assertEquals(negSimplified3.getNum(), -1);
        assertEquals(negSimplified3.getDen(), 2);
        assertEquals(negSimplified4.getNum(), 1);
        assertEquals(negSimplified4.getDen(), 2);
        assertEquals(negSimplified5.getNum(), 1);
        assertEquals(negSimplified5.getDen(), 2);

        // Division by zero errors during instantiation.
        boolean failed = false;
        try
        {
            Rational r = new Rational(1, 0);
        }
        catch ( IllegalArgumentException e )
        {
            failed = true;
        }
        if ( !failed )
        {
            System.out.println("Expected failure on instantiation (1/0)"); 
            Thread.dumpStack();
        }

        // Testing addition.
        System.out.println("Testing rational addition...");
        assertEquals(new Rational(1, 2).add(new Rational(1, 2)),
                new Rational(1, 1));
        assertEquals(new Rational(1, 2).add(new Rational(-1, 2)),
                new Rational(0, 1));
        assertEquals(new Rational(2, 3).add(new Rational(1, 6)),
                new Rational(5, 6));
        assertEquals(new Rational(1, 1).add(new Rational(1, 125)),
                new Rational(126, 125));
        
        // Testing subtraction.
        System.out.println("Testing rational subtraction...");
        assertEquals(new Rational(1, 2).subtract(new Rational(1, 2)),
                new Rational(0, 1));
        assertEquals(new Rational(1, 2).subtract(new Rational(-1, 2)),
                new Rational(1, 1));
        assertEquals(new Rational(2, 3).subtract(new Rational(1, 6)),
                new Rational(1, 2));
        assertEquals(new Rational(1, 1).subtract(new Rational(1, 125)),
                new Rational(124, 125));

        // Testing multiplication.
        System.out.println("Testing rational multiplication...");
        assertEquals(new Rational(1, 2).multiply(new Rational(1, 2)),
                new Rational(1, 4));
        assertEquals(new Rational(-1, 2).multiply(new Rational(-1, 2)),
                new Rational(1, 4));
        assertEquals(new Rational(-1, 2).multiply(new Rational(1, 2)),
                new Rational(-1, 4));
        assertEquals(new Rational(1, 2).multiply(new Rational(-1, 2)),
                new Rational(-1, 4));
        assertEquals(new Rational(2, 3).multiply(new Rational(1, 6)),
                new Rational(1, 9));
        assertEquals(new Rational(1, 1).multiply(new Rational(1, 125)),
                new Rational(1, 125));
        assertEquals(new Rational(5, 1).multiply(new Rational(1, 5)),
                new Rational(1, 1));

        // Testing division.
        System.out.println("Testing rational division...");
        assertEquals(new Rational(1, 2).div(new Rational(1, 2)),
                new Rational(1, 1));
        assertEquals(new Rational(-1, 2).div(new Rational(-1, 2)),
                new Rational(1, 1));
        assertEquals(new Rational(-1, 2).div(new Rational(1, 2)),
                new Rational(-1, 1));
        assertEquals(new Rational(1, 2).div(new Rational(-1, 2)),
                new Rational(-1, 1));
        assertEquals(new Rational(2, 3).div(new Rational(1, 6)),
                new Rational(4, 1));
        assertEquals(new Rational(1, 1).div(new Rational(1, 125)),
                new Rational(125, 1));
        assertEquals(new Rational(5, 1).div(new Rational(1, 5)),
                new Rational(25, 1));

        // Test division by zero fails.
        failed = false;
        try
        {
            Rational r = new Rational(2,3).div(new Rational(0,1));
        }
        catch ( IllegalArgumentException e )
        {
            failed = true;
        }
        if ( !failed )
        {
            System.out.println("Expected failure on (2/3) / (0/1)"); 
            Thread.dumpStack();
        }

        // Relational operators.
        System.out.println("Testing Rational relational operators...");
        assertEquals(new Rational(1, 2).equals(new Rational(1, 2)), true);
        assertEquals(new Rational(1, 2).lte(new Rational(1, 2)), true);
        assertEquals(new Rational(1, 2).lt(new Rational(1, 2)), false);
        assertEquals(new Rational(1, 3).lt(new Rational(1, 2)), true);
        assertEquals(new Rational(1, 2).lt(new Rational(1, 3)), false);
        assertEquals(new Rational(-1,2).lt(new Rational(1, 2)), true);
        assertEquals(new Rational(1,2).gte(new Rational(1, 2)), true);
        assertEquals(new Rational(1,2).gt(new Rational(1, 2)), false);
        assertEquals(new Rational(-1,2).gt(new Rational(1, 2)), false);
        assertEquals(new Rational(1,3).gt(new Rational(1, 2)), false);
        assertEquals(new Rational(1,2).gt(new Rational(1, 3)), true);
    }
}
