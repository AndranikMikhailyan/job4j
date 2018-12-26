package ru.job4j.search;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class PriorityQueueTest {
    @Test
    public void when() {
        var tasks = new PriorityQueue();
        tasks.put(new Task("Task ", 5));
        tasks.put(new Task("Second task", 1));
        tasks.put(new Task("Third task", 3));
        assertThat(tasks.take().getDesc(), is("Second task"));
    }

    @Test
    public void whenHigherPriority2() {
        var queue = new PriorityQueue();
        queue.put(new Task("middle2", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle1", 3));
        queue.put(new Task("low", 8));
        var result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
        result = queue.take();
        assertThat(result.getDesc(), is("middle1"));
        result = queue.take();
        assertThat(result.getDesc(), is("middle2"));
        result = queue.take();
        assertThat(result.getDesc(), is("low"));
    }

}
