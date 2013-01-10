import org.junit.*;
import static org.junit.Assert.*;

public class SymbTest
{
    @Test
    public void testSomething() 
    {
        assertTrue(4 == 4);
    }

    public static junit.framework.Test suite()
    {
        return new junit.framework.JUnit4TestAdapter(SimpleTest.class);
    }
}
