package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] expect = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] result = bubbleSort.sort(input);
        assertThat(result, is(expect));
    }
}
