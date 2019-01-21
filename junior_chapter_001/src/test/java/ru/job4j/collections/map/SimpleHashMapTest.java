package ru.job4j.collections.map;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleHashMapTest {

    @Test
    public void whenAddMorePairThenTrue() {
        SimpleHashMap<Integer, Integer> simpleHashMap = new SimpleHashMap<>();
        assertThat(simpleHashMap.insert(1, 1), is(true));
        assertThat(simpleHashMap.insert(2, 2), is(true));
        assertThat(simpleHashMap.insert(3, 3), is(true));
        assertThat(simpleHashMap.insert(4, 4), is(true));
        assertThat(simpleHashMap.insert(5, 5), is(true));
        assertThat(simpleHashMap.insert(6, 6), is(true));
        assertThat(simpleHashMap.insert(7, 7), is(true));
        assertThat(simpleHashMap.insert(8, 8), is(true));
        assertThat(simpleHashMap.insert(9, 9), is(true));
        assertThat(simpleHashMap.insert(10, 10), is(true));
        assertThat(simpleHashMap.insert(11, 11), is(true));
        assertThat(simpleHashMap.insert(12, 12), is(true));
        assertThat(simpleHashMap.insert(13, 13), is(true));
        assertThat(simpleHashMap.insert(14, 14), is(true));
        assertThat(simpleHashMap.insert(15, 15), is(true));
        assertThat(simpleHashMap.insert(66, 16), is(true));
        assertThat(simpleHashMap.insert(67, 17), is(true));
        //Увеличение размера работает.
    }

    @Test
    public void whenDeleteExistingKeyThenTrue() {
        SimpleHashMap<Integer, Integer> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert(1, 1);
        assertThat(simpleHashMap.delete(1), is(true));

    }

    @Test
    public void whenDeleteNonexistentKeyThenFalse() {
        SimpleHashMap<Integer, Integer> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert(1, 1);
        simpleHashMap.insert(12, 12);
        simpleHashMap.insert(9, 9);
        simpleHashMap.insert(4, 4);
        assertThat(simpleHashMap.delete(2), is(false));

    }

    @Test
    public void whenGet1ThenReturn1() {
        SimpleHashMap<Integer, Integer> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert(1, 1);
        assertThat(simpleHashMap.get(1), is(1));

    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetNonexistentKeyThenNoSuchElementException() {
        SimpleHashMap<Integer, Integer> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert(1, 1);
        simpleHashMap.insert(12, 12);
        simpleHashMap.insert(9, 9);
        simpleHashMap.insert(4, 4);
        simpleHashMap.get(2);
    }

    @Test
    public void whenUseValueIteratorHasNextNextNextHasNextThenTrue112False() {
        SimpleHashMap<Integer, Integer> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert(1, 1);
        simpleHashMap.insert(12, 12);
        Iterator iterator = simpleHashMap.valueIterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(12));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void whenUseKeyIteratorHasNextNextNextHasNextThenTrue112False() {
        SimpleHashMap<Integer, Integer> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert(1, 1);
        simpleHashMap.insert(12, 12);
        Iterator iterator = simpleHashMap.keyIterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(12));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void whenUseEntryIteratorHasNextNextNextHasNextThenTrue112False() {
        SimpleHashMap<Integer, Integer> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert(1, 1);
        simpleHashMap.insert(12, 12);
        Iterator iterator = simpleHashMap.keyIterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(12));
        assertThat(iterator.hasNext(), is(false));
    }
}
