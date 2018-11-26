package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "test desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdateValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 222));
        Input input = new StubInput(new String[]{"2", item.getId(), "replece name", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("replece name"));
    }

    @Test
    public void whenDeleteThenTrue() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "описание", 222));
        Item item2 = tracker.add(new Item("test name2", "desc", 333));
        Input input = new StubInput(new String[]{"3", item1.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item1.getId()), is(item2));
    }
}
