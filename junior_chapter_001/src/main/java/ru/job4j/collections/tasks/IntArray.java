package ru.job4j.collections.tasks;

import java.util.Arrays;

public class IntArray {

    private int[] ints;

    public IntArray(int[] intArray) {
        this.ints = intArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IntArray intArray = (IntArray) o;
        return Arrays.equals(ints, intArray.ints);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(ints);
    }
}
