package pl.michalbidzinski;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RPN2Test {
    private RPN2 calculator;
    @Before
    public void setup() {
        calculator = new RPN2();
    }
    @Test
    public void testCalculateGivenExpression() throws Exception {
        String expression = "2 3 + 5 *";
        int expected = 25;
        assertEquals("(2+3)×5", expected,  calculator.calculate(expression), 0.00001);
    }
    @Test
    public void testCalculateGivenExpression_2() throws Exception {
        String expression = "12 2 3 4 * 10 5 / + * +";
        int expected = 40;
        assertEquals("12+2×(3×4+10/5)", expected,  calculator.calculate(expression), 0.00001);
    }
    @Test
    public void testCalculateGivenExpression_3() throws Exception {
        String expression = "1 2 + 4 * 5 + 3 -";
        int expected = 14;
        assertEquals("(1+2) × 4 + 5 − 3", expected,  calculator.calculate(expression), 0.00001);
    }

    @Test(expected = Exception.class)
    public void testDivideByZero() throws Exception {
        String expression ="1 0 /";
        calculator.calculate(expression);
    }
    @Test(expected = Exception.class)
    public void testNoSpaces() throws Exception {
        String expression = "23+5*";
        calculator.calculate(expression);
    }
    @Test(expected = Exception.class)
    public void testOnlyOperators() throws Exception {
        String expression ="+ +";
        calculator.calculate(expression);
    }
    @Test(expected = Exception.class)
    public void testInvalidCharacters() throws Exception {
        String expression ="a b ";
        calculator.calculate(expression);

    }
    @Test(expected = Exception.class)
    public void testInvalidCharacters_2() throws Exception {
        String expression ="2 3 +5a";
        calculator.calculate(expression);

    }

    @Test(expected = Exception.class)
    public void testInsufficientParameters() throws Exception {

        calculator.calculate("1 2 3 * 5 + * * 6 5");

    }

    @Test(expected = Exception.class)
    public void testStardingWithOperator() throws Exception {

        calculator.calculate("/ 2 1");

    }
    @Test(expected = Exception.class)
    public void testEndingWithNumber() throws Exception {

        calculator.calculate("2 1 / 3");

    }




}
