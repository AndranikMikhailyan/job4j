package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
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
