package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TrackerSingleInnerClassTest {

    @Test
    public void whenCreateThreeThenTrue() {
        Tracker tracker1 = TrackerSingleInnerClass.getInstance();
        Tracker tracker2 = TrackerSingleInnerClass.getInstance();
        Tracker tracker3 = TrackerSingleInnerClass.getInstance();
        assertThat(tracker1.equals(tracker2) && tracker2.equals(tracker3), is(true));
    }
}
