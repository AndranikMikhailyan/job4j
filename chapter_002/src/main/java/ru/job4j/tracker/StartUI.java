package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {

    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструктор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Метод отображает меню в программе.
     */

    /**
     * Основной блок программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        int[] range = new int[menu.getActionsLentgh()];
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range[i] = i;
        }
        int select;
        do {
            menu.show();
            select = (input.ask("Выберите пункт меню:", range));
            menu.select(select);
        } while (select != 6);
    }

    public static void main(String[] args) {
        StartUI startUI = new StartUI(new ValidateInput(new ConsoleInput()), new Tracker());
        startUI.init();
    }
}
