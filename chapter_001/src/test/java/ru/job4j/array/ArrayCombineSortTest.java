package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ArrayCombineSortTest {
    @Test
    public void whenArraysIsEquals() {
        ArrayCombineSort combineSorter = new ArrayCombineSort();
        int[] first = {1, 6, 7, 10, 15};
        int[] second = {2, 5, 8, 9, 14};
        int[] result = combineSorter.combineSort(first, second);
        int[] expect = {1, 2, 5, 6, 7, 8, 9, 10, 14, 15};
        assertThat(result, is(expect));
    }

    @Test
    public void whenArraysIsNotEquals() {
        ArrayCombineSort combineSorter = new ArrayCombineSort();
        int[] first = {1, 6, 7, 10, 15};
        int[] second = {2, 5, 8, 9};
        int[] result = combineSorter.combineSort(first, second);
        int[] expect = {1, 2, 5, 6, 7, 8, 9, 10, 15};
        assertThat(result, is(expect));
    }

    @Test
    public void whenOneOfArraysIsEmpty() {
        ArrayCombineSort combineSorter = new ArrayCombineSort();
        int[] first = {1, 6, 7, 10, 15};
        int[] second = new int[5];
        int[] result = combineSorter.combineSort(first, second);
        int[] expect = {0, 0, 0, 0, 0, 1, 6, 7, 10, 15};
        assertThat(result, is(expect));
    }
}
