package ru.job4j.list;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SortUserTest {

    @Test
    public void when() {
        List<User> users = List.of(
                new User("Петя", 30),
                new User("Саша", 25),
                new User("Аня", 38),
                new User("Яша", 20)
        );
        SortUser sortUser = new SortUser();
        Set<User> result = sortUser.sort(users);
        Set<User> except = Set.of(
                new User("Яша", 20),
                new User("Саша", 25),
                new User("Петя", 30),
                new User("Аня", 38)
        );
        assertThat(result, is(except));
     }

    @Test
    public void whenSortNameLength() {
        User aleksandr = new User("Александр", 30);
        User viktor = new User("Виктор", 30);
        User anya = new User("Аня", 30);
        User dasha = new User("Даша", 30);
        List<User> users = List.of(aleksandr, viktor, anya, dasha);
        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortNameLength(users);
        List<User> except = List.of(anya, dasha, viktor, aleksandr);
        assertThat(result, is(except));
    }

    @Test
    public void whenSortByAllFields() {
        User aleksandr1 = new User("Александр", 30);
        User aleksandr2 = new User("Александр", 29);
        User anya = new User("Аня", 25);
        User dasha = new User("Даша", 30);
        List<User> users = List.of(aleksandr1, aleksandr2, anya, dasha);
        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortByAllFields(users);
        List<User> except = List.of(aleksandr2, aleksandr1, anya, dasha);
        assertThat(result, is(except));
    }
}
