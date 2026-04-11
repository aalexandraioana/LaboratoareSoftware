package test;

import lab6.DoubleCalculator;
import lab6.NewIntCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoubleCalculatorTest {
    private DoubleCalculator doubleCalculator;

    @BeforeEach
    public void setup()
    {
        doubleCalculator = new DoubleCalculator();
    }

    @Test
    public void testAdd()
    {
        doubleCalculator.add(5.0);
        assertEquals(5.0, doubleCalculator.getState());
        doubleCalculator.add(-3.5);
        assertEquals(1.5, doubleCalculator.getState());
        doubleCalculator.add(-1.5);
        assertEquals(0, doubleCalculator.getState());
    }

    @Test
    public void testSubtract()
    {
        doubleCalculator.subtract(8.0);
        assertEquals(-8.0, doubleCalculator.getState());
        doubleCalculator.add(9.5);
        doubleCalculator.subtract(1.0);
        assertEquals(8.5, doubleCalculator.getState());
        doubleCalculator.subtract(8.5);
        assertEquals(0, doubleCalculator.getState());
    }

    @Test
    public void testMultiply()
    {
        doubleCalculator.add(6.0);
        doubleCalculator.multiply(2.0);
        assertEquals(12, doubleCalculator.getState());
        doubleCalculator.multiply(-2.0);
        assertEquals(-24, doubleCalculator.getState());
        doubleCalculator.multiply(-1.0);
        assertEquals(24.0, doubleCalculator.getState());
    }

    @Test
    public void testDivide()
    {
        doubleCalculator.add(10.0);
        doubleCalculator.divide(2.0);
        assertEquals(5.0, doubleCalculator.getState());
        doubleCalculator.multiply(-1.0);
        assertEquals(-5.0, doubleCalculator.getState());
        doubleCalculator.multiply(-5.0);
        assertEquals(1.0, doubleCalculator.getState());
    }

    @Test
    public void testMultiplyBy0()
    {
        doubleCalculator.add(3.0).multiply(0.0);
        assertEquals(0.0, doubleCalculator.getState());
    }

    @Test
    public void testDivideBy0()
    {
        doubleCalculator.add(10.0);
        assertThrows(ArithmeticException.class, () -> {
            doubleCalculator.divide(0.0);
        });
    }

    @AfterEach
    public void tearDown()
    {
        doubleCalculator = null;
    }
}
