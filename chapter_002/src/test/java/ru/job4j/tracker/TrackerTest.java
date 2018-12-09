package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TrackerTest {

    @Test
    public void whenAddItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    @Test
    public void whenReplaceThenTrue() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1238L);
        assertThat(tracker.replace(previous.getId(), next), is(true));
    }

    @Test
    public void whenDeleteThenTrue() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 1238L);
        tracker.add(second);
        assertThat(tracker.delete(first.getId()), is(true));
    }

    @Test
    public void whenTrackerHasThreeItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test", "testDescription", 123L);
        Item item2 = new Item("test", "testDescription", 123L);
        Item item3 = new Item("test", "testDescription", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> expect = new ArrayList<>();
        expect.add(item1);
        expect.add(item2);
        expect.add(item3);
        assertThat(tracker.findAll(), is(expect));
    }

    @Test
    public void whenTwoSameNameOfThreeItems() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 1238L);
        tracker.add(second);
        Item third = new Item("test1", "testDescription", 123L);
        tracker.add(third);
        List<Item> expect = new ArrayList<>();
        expect.add(first);
        expect.add(third);
        assertThat(tracker.findByName("test1"), is(expect));
    }

    @Test
    public void findByIdTest() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

}
