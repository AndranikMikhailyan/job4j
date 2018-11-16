package ru.job4j.loop;

/**
 * @author Andranik Mikhailyan.
 * @version 1.0
 * @since 0.1
 */
public class Counter {

    /**
     * Метод возвращает сумму четных чисел в заданном диапазоне.
     * @return Возвращает сумму
     */

    public int add() {
        int summ = 0;
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                summ += i;
            }
        }
        return summ;
    }
}
