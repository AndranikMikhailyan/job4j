package ru.job4j.chenger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoffeMachine {

    int[] chenges(int value, int price) {
        int difference = value - price;
        int[] coins = new int[]{10, 5, 2, 1};
        List<Integer> temp = new ArrayList<>();
        for (Integer coin : coins) {
            while (difference >= coin) {
                difference -= coin;
                temp.add(coin);
            }
        }
        int[] result = new int[temp.size()];
        int i = 0;
        for (Integer integer : temp) {
            result[i++] = integer;
        }
        return result;
    }
}