package com.xyz.training.calculator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.rules.ExpectedException.none;


public class StringCalculatorTest {

    private StringCalculator calculator;

    @Rule
    public ExpectedException expectedException = none();

    @Before
    public void setUp() throws Exception {
        calculator = new StringCalculator();
    }

    @Test
    public void shouldReturnZeroForEmptyString() throws Exception {
        int result = calculator.calculate("");
        assertThat(result, is(0));
    }

    @Test
    public void shouldReturnZeroForNullInput() throws Exception {
        int result = calculator.calculate(null);
        assertThat(result, is(0));
    }

    @Test
    public void shouldReturnIntegerValueForSingleCharacterInput() throws Exception {
        int result = calculator.calculate("1");
        assertThat(result, is(1));
    }

    @Test
    public void shouldComputeValueForADoubleDigitNumber() throws Exception {
        int result = calculator.calculate("1,2");
        assertThat(result, is(3));
    }

    @Test
    public void shouldComputeSumOfValuesSeparatedByNewLine() throws Exception {
        int result = calculator.calculate("1\n2\n3\n");
        assertThat(result, is(6));
    }

    @Test
    public void shouldThrowIAEOnNegativeValues() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Negative numbers are not allowed");
        calculator.calculate("-1,-2,3");
    }

    @Test
    public void shouldIgnoreAnyNumberEqualTo1000() throws Exception {
        int result = calculator.calculate("10\n20\n1000\n");
        assertThat(result, is(30));
    }
}
