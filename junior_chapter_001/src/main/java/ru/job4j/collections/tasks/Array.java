package ru.job4j.collections.tasks;

import java.util.Arrays;

public class Array<T> {

    private Object[] obj;
    private int index = 0;

    public Array(int size) {
        this.obj = new Object[size];
    }

    public boolean add(T t) {
        if (index == obj.length) {
            throw new ArrayIndexOutOfBoundsException("Массив заполнен");
        }
        obj[index++] = t;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Array<?> array = (Array<?>) o;
        return Arrays.equals(obj, array.obj);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(obj);
    }
}
