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

    @Test
    public void whenSortNameLength() {
        User aleksandr = new User("Александр", 30);
        User viktor = new User("Виктор", 30);
        User anya = new User("Аня", 30);
        User dasha = new User("Даша", 30);
        List<User> users = new ArrayList<>();
        users.add(aleksandr);
        users.add(viktor);
        users.add(anya);
        users.add(dasha);
        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortNameLength(users);
        List<User> except = new ArrayList<>(
                Arrays.asList(anya, dasha, viktor, aleksandr)
        );
        assertThat(result, is(except));
    }

    @Test
    public void whenSortByAllFields() {
        User aleksandr1 = new User("Александр", 30);
        User aleksandr2 = new User("Александр", 29);
        User anya = new User("Аня", 25);
        User dasha = new User("Даша", 30);
        List<User> users = new ArrayList<>();
        users.add(aleksandr1);
        users.add(aleksandr2);
        users.add(anya);
        users.add(dasha);
        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortByAllFields(users);
        List<User> except = new ArrayList<>(
                Arrays.asList(aleksandr2, aleksandr1, anya, dasha)
        );
        assertThat(result, is(except));
    }
}
