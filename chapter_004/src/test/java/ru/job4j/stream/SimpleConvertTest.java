package ru.job4j.stream;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleConvertTest {

    @Test
    public void whenArray12345Then20() {
        int[] ints = new int[] {1, 2, 3, 4, 5};
        SimpleConvert simpleConvert = new SimpleConvert();
        assertThat(simpleConvert.convert(ints), is(20));
    }

    @Test
    public void whenArray123456Then56() {
        int[] ints = new int[] {1, 2, 3, 4, 5, 6};
        SimpleConvert simpleConvert = new SimpleConvert();
        assertThat(simpleConvert.convert(ints), is(56));
    }
}
