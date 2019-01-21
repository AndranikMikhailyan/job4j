package ru.job4j.collections.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArrayList<E> implements Iterable<E> {

    private Object[] array;
    private int index = 0;
    private int modCount = 0;

    public DynamicArrayList(int size) {
        array = new Object[size];
    }

    public DynamicArrayList() {
        this.array = new Object[10];
    }

    public int getLength() {
        return array.length;
    }

    private int newSize() {
        return this.array.length + (this.array.length >> 1) + 1;
    }

    private Object[] grow() {
        array = Arrays.copyOf(array, newSize());
        return array;
    }

    public boolean add(E model) {
        if (index == array.length) {
            this.grow();
        }
        array[index++] = model;
        modCount++;
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= this.index) {
            throw new IndexOutOfBoundsException();
        }
        return (E) array[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {

        private int cursor = 0;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return cursor != index;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) array[cursor++];
        }
    }
}


