package ru.job4j.tracker;

import java.util.function.Consumer;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question, Consumer<String> consumer) {
        return this.input.ask(question, System.out :: println);
    }

    @Override
    public int ask(String question, int[] range, Consumer<String> consumer)     {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range, System.out :: println);
                invalid = false;
            } catch (MenuOutException msg) {
                System.out.println("Введите число из диопазона");
            } catch (NumberFormatException nfe) {
                System.out.println("Введите число");
            }
        } while (invalid);
        return value;
    }
}
