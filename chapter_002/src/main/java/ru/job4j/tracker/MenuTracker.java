package ru.job4j.tracker;

import java.util.ArrayList;

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
        this.actions.add(new AddItem());
        this.actions.add(new FindAllItem());
        this.actions.add(new RepleceItem());
        this.actions.add(new DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemByName());
        this.actions.add(new Exit());
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

    public class AddItem implements UserAction {

        @Override
        public int key() {
            return 0;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Добавить новую заявку.");
        }
    }

    public class FindAllItem implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.findAll();
            for (Item item: items) {
                System.out.println(item.getName() + " " + item.getDesc() + " " + item.getId());
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Показать список всех заявок.");
        }
    }

    public static class RepleceItem implements UserAction {

        @Override
        public int key() {
            return 2;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Редактировать заявку.");
        }
    }

    public static class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 3;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Удалить заявку.");
        }
    }

    public class Exit implements UserAction {

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Выйти из программы.");
        }
    }
}

class FindItemById implements UserAction {

    @Override
    public int key() {
        return 4;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Введите ID заявки которую необходимо найти:");
        Item item = tracker.findById(id);
        System.out.println("Имя заявки с ID - " + id + ": " + item.getName());
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Найти заявку по ID.");
    }
}

class FindItemByName implements UserAction {

    @Override
    public int key() {
        return 5;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Введите имя заявки которую необходимо найти:");
        Item[] items = tracker.findByName(name);
        for (Item item: items) {
            System.out.println("Имя заявки: " + item.getName() + " . Описание заявки: " + item.getDesc());
        }
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Найти заявку по названию.");
    }
}