package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class CounterTest {
    @Test
    public void whenRangeOneToTenThenThirty() {
        Counter counter = new Counter();
        int result = counter.add();
        int expected = 30;
        assertThat(result, is(expected));
    }

}