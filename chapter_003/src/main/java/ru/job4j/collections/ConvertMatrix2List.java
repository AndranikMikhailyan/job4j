package ru.job4j.collections;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] ints) {
        List<Integer> list = new ArrayList<>();
        for (int[] anInt : ints) {
            for (int i : anInt) {
                list.add(i);
            }
        }
        return list;
    }
}
