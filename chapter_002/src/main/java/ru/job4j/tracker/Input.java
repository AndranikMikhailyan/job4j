package ru.job4j.tracker;

import java.util.function.Consumer;

public interface Input {

    String ask(String question, Consumer<String> consumer);

    int ask(String question, int[] range, Consumer<String> consumer);
}
