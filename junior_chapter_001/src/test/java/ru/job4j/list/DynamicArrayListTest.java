package ru.job4j.list;

import org.junit.Test;
import org.junit.Before;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DynamicArrayListTest {

    private DynamicArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new DynamicArrayList<>(1);
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(2), is(3));
    }

    @Test
    public void whenAddThreeElementsThenUseGetLengthResultFour() {
        assertThat(list.getLength(), is(4));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenDeleteThenReturnThree() {
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        list.add(1);
        iterator.hasNext();
    }
}
