package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> integerIterator = it.next();
            @Override
            public boolean hasNext() {
                boolean rslt = false;
                if (integerIterator.hasNext()) {
                    rslt = true;
                } else {
                    while (it.hasNext()) {
                        integerIterator = it.next();
                        if (integerIterator.hasNext()) {
                            rslt = true;
                            break;
                        }
                    }
                }
                return rslt;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return integerIterator.next();
            }
        };
    }
}
