package com.xyz.training.caesershift;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CaeserShiftTest {

    private CaeserShift caeserShift;

    @Before
    public void setUp() throws Exception {
        caeserShift = new CaeserShift();
    }

    @Test
    public void shouldEncodeInputWithSingleAAndAShiftOfZero() throws Exception {
        String result = caeserShift.encode("a", 0);
        assertThat(result, is("a"));
    }

    @Test
    public void shouldEncodeASingleCharacterWithShiftOfOne() throws Exception {
        String result = caeserShift.encode("a", 1);
        assertThat(result, is("b"));
    }

    @Test
    public void shouldEncodeSingleCharacterWithShiftOfTwo() throws Exception {
        String result = caeserShift.encode("a", 2);
        assertThat(result, is("c"));
    }

    @Test
    public void shouldEncodeCharactersThatRequireRollingOver() throws Exception {
        String result = caeserShift.encode("z", 1);
        assertThat(result, is("a"));
    }

    @Test
    public void shouldEncodeRollingOverCharsWithShiftOfTwo() throws Exception {
        String result = caeserShift.encode("z", 2);
        assertThat(result, is("b"));
    }

    @Test
    public void shouldEncodeMultiCharacterStrings() throws Exception {
        String result = caeserShift.encode("ab", 1);
        assertThat(result, is("bc"));
    }

    @Test
    public void shouldEncodeWithShiftGreaterThanAlphabetSize() throws Exception {
        String result = caeserShift.encode("z", 27);
        assertThat(result, is("a"));
    }

    @Test
    public void shouldEncodeWithHighRandomShift() throws Exception {
        String result = caeserShift.encode("z", 26 * 3);
        assertThat(result, is("z"));
    }

    @Test
    public void shouldEncodeWithNegativeShiftValues() throws Exception {
        String result = caeserShift.encode("ab", -1);
        assertThat(result, is("za"));
    }

    @Test
    public void shouldDecodeSingleCharacterWithShiftOfOne() throws Exception {
        String result = caeserShift.decode("a", 1);
        assertThat(result, is("z"));
    }

    @Test
    public void shouldDecodeMultiCharacterStrings() throws Exception {
        String result = caeserShift.decode("bc", 1);
        assertThat(result, is("ab"));
    }
}
