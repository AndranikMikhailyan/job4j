package ru.job4j.collections.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator implements Iterator<Integer> {

    private final int[][] ints;
    private int row = 0;
    private int column = 0;

    public ArrayIterator(int[][] ints) {
        this.ints = ints;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (ints.length == 0) {
            result = false;
        } else if (column < ints[row].length) {
            result = true;
        } else if (++row < ints.length) {
            column = 0;
            result = true;
        }
        return result;
    }

    @Override
    public Integer next() {
        int result = -1;
         if (!hasNext()) {
            throw new NoSuchElementException();
        } else if (column < ints[row].length) {
            result = ints[row][column++];
        } else if (++row < ints.length) {
            column = 0;
            result = ints[row][column++];
        }
        return result;
    }
}
