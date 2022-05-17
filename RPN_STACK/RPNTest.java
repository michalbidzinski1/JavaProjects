package pl.michalbidzinski;
import org.junit.*;


import java.util.EmptyStackException;

import static org.junit.Assert.*;
import static pl.michalbidzinski.RPN.calculate;

public class RPNTest {

    @Test
    public void testCalculateGivenExpression()  {
        String expression = "2 3 + 5 *";
        int expected = 25;
        assertEquals("(2+3)×5", expected,  calculate(expression), 0.00001);
    }
    @Test
    public void testCalculateGivenExpression_2()  {
        String expression = "12 2 3 4 * 10 5 / + * +";
        int expected = 40;
        assertEquals("12+2×(3×4+10/5)", expected,  calculate(expression), 0.00001);
    }
    @Test
    public void testCalculateGivenExpression_3()  {
        String expression = "1 2 + 4 * 5 + 3 -";
        int expected = 14;
        assertEquals("(1+2) × 4 + 5 − 3", expected,  calculate(expression), 0.00001);
    }
    @Test(expected = EmptyStackException.class)
    public void testOnlyOperators() {
        String expression ="+ +";
        calculate(expression);

    }
    @Test(expected = EmptyStackException.class)
    public void testInvalidCharacters() {
        String expression ="a b ";
        calculate(expression);

    }
    @Test(expected = EmptyStackException.class)
    public void testNoSpaces() {
        String expression ="23+5*";
        calculate(expression);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCharacters_2() {
        String expression ="2 3 +5a";
        calculate(expression);

    }
    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        String expression ="1 0 /";
        calculate(expression);

    }
    @Test(expected = NullPointerException.class)
    public void testNullInput() {

        calculate(null);

    }
    @Test(expected = EmptyStackException.class)
    public void testInsuficientParametrs() {

        calculate("1 2 3 * 5 + * * 6 5");

    }


}
