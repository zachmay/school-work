public class Test
{
    public static void assertEquals(Object expected, Object actual)
    {
        if ( !expected.equals(actual) )
        {
            System.out.println("Expected: " + expected.toString() +
                               ", actual: " + actual.toString());
            Thread.dumpStack();
        }
    }

    public static void run()
    {
        // Do nothing. Override in subclasses.
    }
}
