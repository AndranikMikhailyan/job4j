package ru.job4j.loop;

/**
 * @author Andranik Mikhailyan
 * @version 1.0
 * @since 0.1
 */

public class Factorial {

    /**
     * Метод вичисляет факториал введенного числа.
     * @param n Введенное число.
     * @return Возвращает факториал.
     */
    public int calc(int n) {
        int fact = 1;
        for (int i = 1; i < n + 1; i++) {
            if (n == 0) {
                fact = 1;
            } else {
                fact *= i;
            }
        }
        return fact;
    }
}
