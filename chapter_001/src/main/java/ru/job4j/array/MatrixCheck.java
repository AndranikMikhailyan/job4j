package ru.job4j.array;

public class MatrixCheck {

    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1; j++) {
                if (data[i][j] != data[i + 1][j + 1]) {
                    result = false;
                    break;
                }
            }
            if (!result) {
                break;
            }
        }
        if (result) {
            for (int i = 0; i < data.length - 1; i++) {
                for (int j = data.length - 1; j > 0; j--) {
                    if (data[i][j] != data[i + 1][j - 1]) {
                        result = false;
                        break;
                    }
                }
                if (!result) {
                    break;
                }
            }
        }
        return result;
    }
}
