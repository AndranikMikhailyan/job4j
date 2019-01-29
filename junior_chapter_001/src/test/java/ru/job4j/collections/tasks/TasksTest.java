package ru.job4j.collections.tasks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public void whenMargarinThenReturnAR() {
        Tasks tasks = new Tasks();
        assertThat(tasks.duplicatesChars("Margarinm"), is(new ArrayList(List.of('a', 'm', 'r'))));
    }

    @Test
    public void arrayAsKey() {
        IntArray first = new IntArray(new int[] {1, 2, 3});
        IntArray second = new IntArray(new int[] {1, 2});
        HashMap<IntArray, String> hashMap = new HashMap<>();
        hashMap.put(first, "первый");
        hashMap.put(second, "второй");
        assertThat(hashMap.size(), is(2));
        assertThat(hashMap.get(first), is("первый"));
        assertThat(hashMap.get(second), is("второй"));
    }

    @Test
    public void arrayAsKey2() {
        IntArray first = new IntArray(new int[] {1, 2});
        IntArray second = new IntArray(new int[] {1, 2});
        HashMap<IntArray, String> hashMap = new HashMap<>();
        hashMap.put(first, "первый");
        hashMap.put(second, "второй");
        assertThat(hashMap.size(), is(1));
        assertThat(hashMap.get(first), is("второй"));
        assertThat(hashMap.get(second), is("второй"));
    }
}
