package ru.job4j.collections.list;

import org.junit.Test;
import org.junit.Before;
import ru.job4j.collections.list.SimpleQueue;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {

    private SimpleQueue<Integer> queue;

    @Before
    public void beforeTest() {
        queue = new SimpleQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
    }

    @Test
    public void whenAddThreeElementsThenUsePollResult12345() {
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
        queue.push(4);
        queue.push(5);
        assertThat(queue.poll(), is(4));
        assertThat(queue.poll(), is(5));
    }

    @Test
    public void whenUsePushPushPollPushPollThen12() {
        queue.push(4);
        queue.push(5);
        assertThat(queue.poll(), is(1));
        queue.push(6);
        assertThat(queue.poll(), is(2));

    }
}
