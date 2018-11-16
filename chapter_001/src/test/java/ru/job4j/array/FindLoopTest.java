package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class FindLoopTest {
    @Test
    public void whenHas5Then0() {
        FindLoop findLoop = new FindLoop();
        int[] ints = new int[] {5, 3, 8};
        int el = 5;
        int result = findLoop.indexOf(ints, el);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenDoNotHasEl() {
        FindLoop findLoop = new FindLoop();
        int[] ints = new int[] {5, 3, 8};
        int el = 4;
        int result = findLoop.indexOf(ints, el);
        int expect = -1;
        assertThat(result, is(expect));
    }
}
