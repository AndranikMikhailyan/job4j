package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TrackerTest {

    @Test
    public void whenAddItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    @Test
    public void whenReplaceItemThenTrackerHasReplacedItem() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1238L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteFirstItemThenSecondMoveToIndexOfFirstIndex() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("test2", "testDescription2", 1238L);
        tracker.add(second);
        tracker.delete(first.getId());
        assertThat(tracker.findById(second.getId()).getName(), is("test2"));
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
        Item[] expect = new Item[3];
        expect[0] = item1;
        expect[1] = item2;
        expect[2] = item3;
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
        Item[] expect = new Item[2];
        expect[0] = first;
        expect[1] = third;
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
