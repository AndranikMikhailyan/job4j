package ru.job4j.collections.set;

import ru.job4j.collections.list.DynamicArrayList;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {

    private DynamicArrayList<E> set = new DynamicArrayList<>();

    private int size = 0;

    private boolean contains(E e) {
        boolean result = false;
        for (E e1 : set) {
            if (e1.equals(e)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void add(E e) {
        if (!contains(e)) {
            set.add(e);
            size++;
        }
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }
}
