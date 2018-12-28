package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TrackerSingleLazyTest {

    @Test
    public void whenCreateThreeThenTrue() {
        Tracker tracker1 = TrackerSingleLazy.getInstance();
        Tracker tracker2 = TrackerSingleLazy.getInstance();
        Tracker tracker3 = TrackerSingleLazy.getInstance();
        assertThat(tracker1.equals(tracker2) && tracker2.equals(tracker3), is(true));
    }
}
