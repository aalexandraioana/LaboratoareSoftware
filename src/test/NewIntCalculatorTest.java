package test;
import lab6.NewIntCalculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NewIntCalculatorTest
{
    private NewIntCalculator intCalculator;

    @BeforeEach
    public void setup()
    {
        intCalculator = new NewIntCalculator();
    }

    @Test
    public void testAdd()
    {
        intCalculator.add(5);
        assertEquals(5, intCalculator.getState());
        intCalculator.add(-3);
        assertEquals(2, intCalculator.getState());
        intCalculator.add(-2);
        assertEquals(0, intCalculator.getState());
    }

    @Test
    public void testSubtract()
    {
        intCalculator.subtract(8);
        assertEquals(-8, intCalculator.getState());
        intCalculator.add(10);
        intCalculator.subtract(1);
        assertEquals(1, intCalculator.getState());
        intCalculator.subtract(1);
        assertEquals(0, intCalculator.getState());
    }

    @Test
    public void testMultiply()
    {
        intCalculator.add(6);
        intCalculator.multiply(2);
        assertEquals(12, intCalculator.getState());
        intCalculator.multiply(-2);
        assertEquals(-24, intCalculator.getState());
        intCalculator.multiply(-1);
        assertEquals(24, intCalculator.getState());
    }

    @Test
    public void testDivide()
    {
        intCalculator.add(10);
        intCalculator.divide(2);
        assertEquals(5, intCalculator.getState());
        intCalculator.multiply(-1);
        assertEquals(-5, intCalculator.getState());
        intCalculator.multiply(-5);
        assertEquals(1, intCalculator.getState());
    }

    @Test
    public void testMultiplyBy0()
    {
        intCalculator.add(3).multiply(0);
        assertEquals(0, intCalculator.getState());
    }

    @Test
    public void testDivideBy0()
    {
        intCalculator.add(10);
        assertThrows(ArithmeticException.class, () -> {
            intCalculator.divide(0);
        });
    }

    @AfterEach
    public void tearDown()
    {
        intCalculator = null;
    }
}
