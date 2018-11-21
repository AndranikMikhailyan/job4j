package ru.job4j.array;

public class ArrayCombineSort {

    public int[] combineSort(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        for (int i = 0, x = 0, y = 0; i < result.length; i++) {
            if (x == first.length || y == second.length) {
                if (y == second.length) {
                    result[i] = first[x];
                    x++;
                } else {
                    result[i] = second[y];
                    y++;
                }
            } else {
                if (first[x] <= second[y]) {
                    result[i] = first[x];
                    x++;
                } else {
                    result[i] = second[y];
                    y++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayCombineSort combineSorter = new ArrayCombineSort();
        int[] first = {1, 6, 7, 10, 15};
        int[] second = {2, 5, 8, 9, 14};
        int[] result = combineSorter.combineSort(first, second);
        int[] expect = {1, 2, 5, 6, 7, 8, 9, 10, 14, 15};
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}