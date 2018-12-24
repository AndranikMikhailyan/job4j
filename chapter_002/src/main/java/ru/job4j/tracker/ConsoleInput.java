package ru.job4j.tracker;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public String ask(String question, Consumer<String> consumer) {
        consumer.accept(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, int[] range, Consumer<String> consumer) {
        int key = Integer.valueOf(this.ask(question, System.out :: println));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Введите число из диопазона");
        }
        return key;
    }
}
