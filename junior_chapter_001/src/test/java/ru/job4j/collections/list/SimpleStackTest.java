package ru.job4j.collections.list;

import org.junit.Test;
import org.junit.Before;
import ru.job4j.collections.list.SimpleStack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {

    private SimpleStack<Integer> stack;

    @Before
    public void beforeTest() {
        stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void whenAddThreeElementsThenUsePollResult321() {
        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
    }
}
