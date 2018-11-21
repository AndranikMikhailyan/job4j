package ru.job4j.max;

/**
 * @author Andranik Mikhailyan.
 * @version 1.0
 * @since 0.1
 */

public class Max {

    /**
     * Возвращает максимум из двух чисел.
     *
     * @param first  Первое число.
     * @param second Второе число.
     */
    public int max(int first, int second) {
        return (first > second ? first : second);
    }

    /**
     * Возвращает максимум из nht[ чисел.
     *
     * @param first  Первое число.
     * @param second Второе число.
     * @param third Третье число.
     */
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}

