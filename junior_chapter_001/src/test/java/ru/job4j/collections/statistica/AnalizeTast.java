package ru.job4j.collections.statistica;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class AnalizeTast {

    List<User> previous = new ArrayList<>(Arrays.asList(
            new User("First", 101),
            new User("Second", 102),
            new User("Third", 103),
            new User("Four", 104),
            new User("Five", 105)
    )
    );
    List<User> current = new ArrayList<>(Arrays.asList(
            new User("Not Second", 102),
            new User("Third", 103),
            new User("Four", 104),
            new User("six", 106)
    )
    );
    Analize analize = new Analize();

    @Test
    public void whenAddedOneAndChangedOneAndDeletedTwoThenAssertThat112() {
        assertThat(analize.diff(previous, current).added, is(1));
        assertThat(analize.diff(previous, current).changed, is(1));
        assertThat(analize.diff(previous, current).deleted, is(2));
    }
}
