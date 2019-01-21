package ru.job4j.collections.generic;

import org.junit.Test;
import ru.job4j.collections.generic.SimpleArray;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleArrayTest {

    @Test
    public void whenAddElementThenTrue() {
        SimpleArray<Integer> integers = new SimpleArray<>(2);
        assertThat(integers.add(1), is(true));
        assertThat(integers.add(2), is(true));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddElementInOutIndexThenException() {
        SimpleArray<Integer> integers = new SimpleArray<>(2);
        assertThat(integers.add(1), is(true));
        assertThat(integers.add(2), is(true));
        assertThat(integers.add(2), is(true));
    }

    @Test
    public void whenSetElement1Then2() {
        SimpleArray<Integer> integers = new SimpleArray<>(2);
        integers.add(1);
        integers.set(0, 2);
        assertThat(integers.get(0), is(2));
    }

    @Test
    public void whenRemoveElement1ThenTrueAdnLastElementEqualsNull() {
        SimpleArray<Integer> integers = new SimpleArray<>(6);
        integers.add(0);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        assertThat(integers.remove(1) && integers.remove(1), is(true));
    }

    @Test
    public void whenGetElementThen() {
        SimpleArray<Integer> integers = new SimpleArray<>(2);
        integers.add(1);
        integers.add(2);
        assertThat(integers.get(0), is(1));
        assertThat(integers.get(1), is(2));
    }

}
