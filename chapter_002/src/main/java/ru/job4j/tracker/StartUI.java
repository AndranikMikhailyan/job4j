package ru.job4j.tracker;

import java.util.function.Consumer;

public class StartUI {

    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final ITracker tracker;

    private Consumer<String> consumer;

    /**
     * Конструктор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, ITracker tracker, Consumer<String> consumer) {
        this.input = input;
        this.tracker = tracker;
        this.consumer = consumer;
    }
    /**
     * Метод отображает меню в программе.
     */

    /**
     * Основной блок программы.
     * Выводит меню.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, consumer);
        menu.fillActions();
        int[] range = new int[menu.getActionsLentgh()];
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range[i] = i;
        }
        int select;
        do {
            menu.show();
            select = (input.ask("Выберите пункт меню:", range, consumer));
            menu.select(select);
        } while (select != 6);
    }

    public static void main(String[] args) {
        StartUI startUI = new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out :: println);
        startUI.init();
    }
}
