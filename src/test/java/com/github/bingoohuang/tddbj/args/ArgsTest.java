package com.github.bingoohuang.tddbj.args;

import com.github.bingoohuang.tddbj.args.exception.ArgFormatException;
import com.github.bingoohuang.tddbj.args.exception.ArgNotFoundException;
import com.github.bingoohuang.tddbj.args.exception.ArgSchemaNotDefinedException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ArgsTest {
    @Test
    public void testBooleanTrue() {
        Args args = new Args("v", new String[]{"-v"});
        boolean verbose = args.getBoolean('v');
        assertThat(verbose, is(true));
    }

    @Test
    public void testBooleanFalse() {
        Args args = new Args("v", new String[]{});
        boolean verbose = args.getBoolean('v');
        assertThat(verbose, is(false));
    }

    @Test(expected = ArgSchemaNotDefinedException.class)
    public void testBooleanPatternFail() {
        Args args = new Args("b", new String[]{});
        args.getBoolean('v');
    }

    @Test
    public void testInt() {
        Args args = new Args("p#", new String[]{"-p8080"});
        int port = args.getInt('p');
        assertThat(port, is(8080));
    }

    @Test(expected = ArgFormatException.class)
    public void testIntBadFormat() {
        Args args = new Args("p#", new String[]{"-pabc"});
        args.getInt('p');
    }

    @Test(expected = ArgNotFoundException.class)
    public void testIntNotFound() {
        Args args = new Args("p#", new String[]{"-b8080"});
        args.getInt('p');
    }

    @Test
    public void testString() {
        Args args = new Args("p*", new String[]{"-p/var/log"});
        String path = args.getString('p');
        assertThat(path, is(equalTo("/var/log")));
    }

    @Test
    public void testComposition() {
        Args args = new Args("v,p#,d*",
                new String[]{"-v", "-p9090", "-d/var/log"});
        assertThat(args.getBoolean('v'), is(true));
        assertThat(args.getInt('p'), is(9090));
        assertThat(args.getString('d'),is(equalTo("/var/log")));
    }
}
