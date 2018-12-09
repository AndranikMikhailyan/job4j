package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private ArrayList<UserAction> actions = new ArrayList<>();

    public int getActionsLentgh() {
        return this.actions.size();
    }

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions.add(new AddItem(0, "Добавить новую заявку."));
        this.actions.add(new FindAllItem(1, "Показать список всех заявок."));
        this.actions.add(new RepleceItem(2, "Редактировать заявку."));
        this.actions.add(new DeleteItem(3, "Удалить заявку."));
        this.actions.add(new FindItemById(4, "Найти заявку по ID."));
        this.actions.add(new FindItemByName(5, "Найти заявку по названию."));
        this.actions.add(new Exit(6, "Выйти из программы."));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        System.out.println("Меню.");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки ------------");
            String name = input.ask("Введите имя заявки:");
            String desc = input.ask("Введите описание заявки:");
            Item item = new Item(name, desc, 222);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }
    }

    public class FindAllItem extends BaseAction {

        public FindAllItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            List<Item> items = tracker.findAll();
            for (Item item: items) {
                System.out.println(item.getName() + " " + item.getDesc() + " " + item.getId());
            }
        }
    }

    public static class RepleceItem extends BaseAction {

        public RepleceItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите ID редактируемой заявки:");
            String name = input.ask("Введите новое имя заявки:");
            String desc = input.ask("Введите новое описание заявки:");
            Item item = new Item(name, desc, 222);
            if (tracker.replace(id, item)) {
                System.out.println(
                        "Заявка отредактирована. Новое имя заявки - "
                                + item.getName() + ", " + "новое описание - " + item.getDesc() + ".");
            } else {
                System.out.println("Заявки с ID: " + id + " не существует.");
            }
        }
    }

    public static class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите ID заявки которую необходимо удалить:");
            if (tracker.delete(id)) {
                System.out.println("Заявка удалена!");
            } else {
                System.out.println("Заявка не удалена!");
            }
        }
    }

    public class Exit extends BaseAction {

        public Exit(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }
    }
}

class FindItemById extends BaseAction {

    public FindItemById(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите ID заявки которую необходимо найти:");
        Item item = tracker.findById(id);
        System.out.println("Имя заявки с ID - " + id + ": " + item.getName());
    }
}

class FindItemByName extends BaseAction {

    public FindItemByName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Введите имя заявки которую необходимо найти:");
        List<Item> items = tracker.findByName(name);
        for (Item item: items) {
            System.out.println("Имя заявки: " + item.getName() + " . Описание заявки: " + item.getDesc());
        }
    }
}