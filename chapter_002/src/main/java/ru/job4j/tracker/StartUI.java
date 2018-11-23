package ru.job4j.tracker;

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа для выхода списка заявок.
     */
    private static final String FIND_ALL = "1";
    /**
     * Константа для редактирования заявки.
     */
    private static final String REPLECE = "2";
    /**
     * Константа для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа для выхода заявки по ID.
     */
    private static final String FIND_BY_ID = "4";
    /**
     * Константа для выхода заявки по названию.
     */
    private static final String FIND_BY_NAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
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
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Добавить новую заявку.");
        System.out.println("1. Показать список всех заявок.");
        System.out.println("2. Редактировать заявку.");
        System.out.println("3. Удалить заявку.");
        System.out.println("4. Найти заявку по ID.");
        System.out.println("5. Найти заявку по названию.");
        System.out.println("6. Выйти из программы.");
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    protected void createItem() {
        System.out.println("------------ Добавление новой заявки ------------");
        String name = this.input.ask("Введите имя заявки:");
        String desc = this.input.ask("Введите описание заявки:");
        Item item = new Item(name, desc, 222);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Основной блок программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню:");
            if (answer.equals(ADD)) {
                this.createItem();
            } else if (answer.equals(FIND_ALL)) {
                Item[] items = this.tracker.findAll();
                for (Item item: items) {
                    System.out.println(item.getName() + " " + item.getDesc() + " " + item.getId());
                }
            } else if (answer.equals(REPLECE)) {
                String id = this.input.ask("Введите ID редактируемой заявки:");
                String name = this.input.ask("Введите новое имя заявки:");
                String desc = this.input.ask("Введите новое описание заявки:");
                Item item = new Item(name, desc, 222);
                this.tracker.replace(id, item);
                System.out.println(
                        "Заявка отредактирована. Новое имя заявки - "
                                + item.getName() + ", " + "новое описание - " + item.getDesc() + ".");
            } else if (answer.equals(DELETE)) {
                String id = this.input.ask("Введите ID заявки которую необходимо удалить:");
                this.tracker.delete(id);
                System.out.println("Заявка удалена!");
            } else if (answer.equals(FIND_BY_ID)) {
                String id = this.input.ask("Введите ID заявки которую необходимо найти:");
                Item item = this.tracker.findById(id);
                System.out.println("Имя заявки с ID - " + id + ": " + item.getName());
            } else if (answer.equals(FIND_BY_NAME)) {
                String name = this.input.ask("Введите имя заявки которую необходимо найти:");
                Item[] items = this.tracker.findByName(name);
                for (Item item: items) {
                    System.out.println("Имя заявки: " + item.getName() + " . Описание заявки: " + item.getDesc());
                }
            } else if (answer.equals(EXIT)) {
                exit = true;
            }
        }
    }

    public static void main(String[] args) {
        StartUI startUI = new StartUI(new ConsoleInput(), new Tracker());
        startUI.init();
    }
}
