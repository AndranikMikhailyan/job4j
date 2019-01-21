package ru.job4j.collections.generic;

import java.util.Arrays;

public class SimpleArray<T> {

    private Object[] array;
    private int index = 0;

    public SimpleArray(int size) {
        array = new Object[size];
    }

    public boolean add(T model) {
        if (index == array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        array[index++] = model;
        return true;
    }

    public void set(int index, T model) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = model;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        array[--this.index] = null;
        return true;
    }

    public T get(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }
}
