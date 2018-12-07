package ru.job4j.chenger;

public class CoffeMachine {

    int[] chenges(int value, int price) {
        int difference = value - price;
        int count10 = 0;
        int count5 = 0;
        int count2 = 0;
        int count1 = 0;
        int arrayLenght = 0;
        for (int i = difference; i >= 10; i -= 10) {
            difference -= 10;
            count10++;
        }
        for (int i = difference; i >= 5; i -= 5) {
            difference -= 5;
            count5++;
        }
        for (int i = difference; i >= 2; i -= 2) {
            difference -= 2;
            count2++;
        }
        for (int i = difference; i >= 1; i -= 1) {
            difference -= 1;
            count1++;
        }
        arrayLenght = count10 + count5 + count2 + count1;
        int[] chenges = new int[arrayLenght];
        if (count10 > 0) {
            for (int i = 0; i < count10; i++) {
                chenges[i] = 10;
            }
        }
        if (count5 > 0) {
            for (int i = count10; i < count10 + count5; i++) {
                chenges[i] = 5;
            }
        }
        if (count2 > 0) {
            for (int i = count10 + count5; i < count10 + count5 + count2; i++) {
                chenges[i] = 2;
            }
        }
        if (count1 > 0) {
            chenges[chenges.length - 1] = 1;
        }
        return chenges;
    }
}
