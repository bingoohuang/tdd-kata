package com.github.bingoohuang.tddbj;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.github.bingoohuang.tddbj.BaseConverter.convert;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BaseConverterTest {
    @Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                {1, 2, "1"},
                {2, 2, "10"},
                {3, 2, "11"},
                {10, 8, "12"},
                {20, 16, "14"},
                {15, 16, "F"},
                {40, 20, "20"},
                {40, 8, "50"},
        });
    }

    private final int decimal;
    private final int base;
    private final String expected;

    public BaseConverterTest(int decimal, int base, String expected) {
        this.decimal = decimal;
        this.base = base;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertThat(convert(decimal, base), is(equalTo(expected)));
    }

    @Test(expected = RuntimeException.class)
    public void testException() {
        convert(1, 100);
    }
}
