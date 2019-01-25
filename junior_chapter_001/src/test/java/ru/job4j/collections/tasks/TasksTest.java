package ru.job4j.collections.tasks;

import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TasksTest {

    @Test
    public void whenSameCharsThenTrue() {
        Tasks tasks = new Tasks();
        assertThat(tasks.containSameChar("мама", "амам"), is(true));
    }

    @Test
    public void whenNotSameCharsThenFalse() {
        Tasks tasks = new Tasks();
        assertThat(tasks.containSameChar("Мама", "Аммм"), is(false));
    }

    @Test
    public void whenNotSameLengthChatsThenFalse() {
        Tasks tasks = new Tasks();
        assertThat(tasks.containSameChar("Мама", "Амм"), is(false));
    }

    @Test
    public void arrayAsKey() {
        Array<Integer> first = new Array<>(2);
        first.add(1);
        Array<Integer> second = new Array<>(2);
        second.add(2);
        HashMap<Array, String> hashMap = new HashMap<>();
        hashMap.put(first, "первый");
        hashMap.put(second, "второй");
        assertThat(hashMap.size(), is(2));
        assertThat(hashMap.get(first), is("первый"));
        assertThat(hashMap.get(second), is("второй"));
    }

    @Test
    public void arrayAsKey2() {
        Array<Integer> first = new Array<>(2);
        first.add(1);
        Array<Integer> second = new Array<>(2);
        second.add(1);
        HashMap<Array, String> hashMap = new HashMap<>();
        hashMap.put(first, "первый");
        hashMap.put(second, "второй");
        assertThat(hashMap.size(), is(1));
        assertThat(hashMap.get(first), is("второй"));
        assertThat(hashMap.get(second), is("второй"));
    }
}
