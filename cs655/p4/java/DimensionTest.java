public class DimensionTest extends Test
{
    public static void run()
    {
        // Test creation of Dimension values.
        System.out.println("Testing dimension creation...");
        Dimension scalar       = Dimension.scalar();
        Dimension length       = Dimension.length();
        Dimension mass         = Dimension.mass();
        Dimension time         = Dimension.time();
        Dimension velocity     = Dimension.velocity();
        Dimension acceleration = Dimension.acceleration();
        Dimension area         = Dimension.area();
        Dimension density      = Dimension.density();

        assertEquals(scalar, new Dimension(0, 0, 0));
        assertEquals(length, new Dimension(1, 0, 0));
        assertEquals(mass, new Dimension(0, 1, 0));
        assertEquals(time, new Dimension(0, 0, 1));
        assertEquals(velocity, new Dimension(1, 0, -1));
        assertEquals(acceleration, new Dimension(1, 0, -2));
        assertEquals(area, new Dimension(2, 0, 0));
        assertEquals(density, new Dimension(-3, 1, 0));

        // Test inversion of Dimension values, e.g., m -> m^(-1), etc.
        System.out.println("Testing dimensional inversion...");
        Dimension invAcceleration = acceleration.invert();
        Dimension invDensity      = density.invert();
        assertEquals(invAcceleration, new Dimension(-1, 0, 2));
        assertEquals(invDensity     , new Dimension(3, -1, 0));

        // Test multiplication of Dimension values.
        System.out.println("Testing dimensional multiplication...");
        assertEquals(scalar.multiply(acceleration), acceleration);
        assertEquals(length.multiply(length), area);
        assertEquals(velocity.multiply(time), length);

        // Test division of Dimension values.
        System.out.println("Testing dimensional division...");
        assertEquals(length.div(length), scalar);
        assertEquals(time.div(time), scalar);
        assertEquals(mass.div(mass), scalar);
        assertEquals(length.div(time), velocity);
        assertEquals(area.div(length), length);
        assertEquals(velocity.div(time), acceleration);
        assertEquals(acceleration.div(scalar), acceleration);
    }
}

