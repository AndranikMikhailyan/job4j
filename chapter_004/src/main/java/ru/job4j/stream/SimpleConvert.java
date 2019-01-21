package ru.job4j.stream;

import java.util.Arrays;

public class SimpleConvert {

    public int convert(int[] array) {
        return Arrays.stream(array)
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .reduce(0, (sum, x) -> sum = sum + x);
    }
}
