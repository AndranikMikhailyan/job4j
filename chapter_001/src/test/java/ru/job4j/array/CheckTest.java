package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class CheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] data = new boolean[] {true, true, true};
        assertThat(check.mono(data), is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] data = new boolean[] {true, false, true};
        assertThat(check.mono(data), is(false));
    }
}
