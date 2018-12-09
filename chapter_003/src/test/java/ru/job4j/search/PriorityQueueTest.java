package ru.job4j.search;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class PriorityQueueTest {
    @Test
    public void when() {
        PriorityQueue tasks = new PriorityQueue();
        tasks.put(new Task("Task ", 5));
        tasks.put(new Task("Second task", 1));
        tasks.put(new Task("Third task", 3));
        assertThat(tasks.take().getDesc(), is("Second task"));
    }


}
