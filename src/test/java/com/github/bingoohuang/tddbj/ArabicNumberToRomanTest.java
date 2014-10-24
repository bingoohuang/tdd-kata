package com.github.bingoohuang.tddbj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.github.bingoohuang.tddbj.ArabicNumberToRoman.convert;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ArabicNumberToRomanTest {
    private final int arabicNumber;
    private final String expectedRomanNumber;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, "I"},
                {2, "II"},
                {3, "III"},
                {4, "IV"},
                {5, "V"},
                {8, "VIII"},
                {9, "IX"},
                {10, "X"},
                {30, "XXX"},
                {40, "XL"},
                {1024, "MXXIV"},
        });
    }

    public ArabicNumberToRomanTest(int arabicNumber,
                                   String expectedRomanNumber) {
        this.arabicNumber = arabicNumber;
        this.expectedRomanNumber = expectedRomanNumber;
    }

    @Test
    public void test() {
        assertThat(convert(arabicNumber),
                is(equalTo(expectedRomanNumber)));
    }
}
