package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;


public class ArrayDuplicateTest {

    @Test
    public void whenArrayHasDuplicatesThenDropIt() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] input = {"1", "1", "2", "3", "3", "2", "1", };
        String[] result = duplicate.remove(input);
        String[] expect = {"1", "2", "3"};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}
