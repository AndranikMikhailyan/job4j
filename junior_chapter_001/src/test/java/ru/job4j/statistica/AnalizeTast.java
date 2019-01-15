package ru.job4j.statistica;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class AnalizeTast {

    User first = new User("First", 101);
    User second = new User("Second", 102);
    User third = new User("Third", 103);
    User four = new User("Four", 104);
    User five = new User("Five", 105);
    List<User> previous = new ArrayList<>(Arrays.asList(first, second, third, four));
    List<User> current = new ArrayList<>(Arrays.asList(second, third, four, five));
    Analize analize = new Analize();

    @Before
    public void set() {
        second.setName("Not second");
    }
    @Test
    public void whenAddedOneUserThenReturn1() {
        assertThat(analize.diff(previous, current).added, is(1));
    }

    @Test
    public void whenChangedOneUserThenReturn1() {
        // Тут у меня вопрос. Так как листы хранят ссылки на объекты то при изменении имени не получается отследить
        // это изменение если только в методе setName() не увеличивать какой нибудь счетчик изменения имени.
        //
        assertThat(analize.diff(previous, current).changed, is(1));
    }

    @Test
    public void whenDeletedOneUserThenReturn1() {
        assertThat(analize.diff(previous, current).deleted, is(1));
    }
}
