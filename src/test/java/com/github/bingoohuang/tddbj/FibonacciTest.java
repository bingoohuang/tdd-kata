package com.github.bingoohuang.tddbj;

import com.github.bingoohuang.tddbj.Fibonacci;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FibonacciTest {

    @Test
    public void fib0() {
        assertThat(Fibonacci.fib(0), is(0));
    }

    @Test
    public void fib1() {
        assertThat(Fibonacci.fib(1), is(1));
    }

    @Test
    public void fib2() {
        assertThat(Fibonacci.fib(2), is(1));
    }

    @Test
    public void fib3() {
        assertThat(Fibonacci.fib(3), is(2));
    }

    @Test
    public void fib4() {
        assertThat(Fibonacci.fib(4), is(3));
    }

    @Test
    public void fib5() {
        assertThat(Fibonacci.fib(5), is(5));
    }
}
