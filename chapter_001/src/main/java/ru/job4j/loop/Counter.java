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

    public int add(int start, int finish) {
        int summ = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                summ += i;
            }
        }
        return summ;
    }
}
