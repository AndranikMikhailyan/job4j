package ru.job4j.list;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SortUserTest {

    @Test
    public void when() {
        List<User> users = new ArrayList<>();
        users.add(new User("Петя", 30));
        users.add(new User("Саша", 25));
        users.add(new User("Аня", 38));
        users.add(new User("Яша", 20));
        SortUser sortUser = new SortUser();
        Set<User> result = sortUser.sort(users);
        Set<User> except = new TreeSet<>(
                Arrays.asList(
                        new User("Яша", 20),
                        new User("Саша", 25),
                        new User("Петя", 30),
                        new User("Аня", 38)
                )
            );
        assertThat(result, is(except));
     }
}
