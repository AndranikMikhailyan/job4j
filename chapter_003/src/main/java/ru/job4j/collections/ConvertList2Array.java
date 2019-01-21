package ru.job4j.collections;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (list.size() - list.size() % rows) / rows + 1;
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
        for (Integer integer : list) {
            if (j == cells) {
                i++;
                j = 0;
            }
            array[i][j++] = integer;
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        list.forEach(ints -> {
            for (int anInt : ints) {
                result.add(anInt);
            }
        });
        return result;
    }
}
