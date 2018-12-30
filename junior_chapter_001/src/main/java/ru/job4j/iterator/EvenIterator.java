package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {

    private final int[] ints;
    private int index = 0;

    public EvenIterator(int[] ints) {
        this.ints = ints;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (ints.length == 0) {
            result = false;
        }
        for (int i = index; i < ints.length; i++) {
            if (ints[i] % 2 == 0) {
                result = true;
                break;
            }
            index++;
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return ints[index++];
    }

    public static void main(String[] args) {
        EvenIterator it = new EvenIterator(new int[]{1, 2, 3, 4, 5, 6, 7});

        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
    }
}
