package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TrackerSingleEnamTest {

    @Test
    public void whenCreateThreeThenTrue() {
        TrackerSingleEnam tracker1 = TrackerSingleEnam.INSTANCE;
        TrackerSingleEnam tracker2 = TrackerSingleEnam.INSTANCE;
        TrackerSingleEnam tracker3 = TrackerSingleEnam.INSTANCE;
        assertThat(tracker1.equals(tracker2) && tracker2.equals(tracker3), is(true));
    }
}
