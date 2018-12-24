package ru.job4j.tracker;

import java.util.function.Consumer;

public class StubInput implements Input {

    private final String[] value;
    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String question, Consumer<String> consumer) {
        return this.value[this.position++];
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
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Выберите пункт меню из диопазона.");
        }
    }
}
