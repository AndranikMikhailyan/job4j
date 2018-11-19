package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class MatrixCheckTest {
    @Test
    public void whenMatrix3x3() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] matrix = new boolean[][]{
                {false, false, false},
                {false, false, false},
                {false, false, false}
        };
        assertThat(matrixCheck.mono(matrix), is(true));
    }

    @Test
    public void whenMatrix2x2() {
        MatrixCheck matrixCheck = new MatrixCheck();
        boolean[][] matrix = new boolean[][]{
                {false, true},
                {true, false}
        };
        assertThat(matrixCheck.mono(matrix), is(true));
    }
}


