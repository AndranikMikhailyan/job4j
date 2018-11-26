package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "test desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdateValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 222));
        Input input = new StubInput(new String[]{"2", item.getId(), "replece name", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("replece name"));
    }

    @Test
    public void whenDeleteThen() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "описание", 222));
        Item item2 = tracker.add(new Item("test name2", "desc", 333));
        Input input = new StubInput(new String[]{"3", item1.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is(item2.getName()));
    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "описание", 222));
        Item item2 = tracker.add(new Item("test name2", "desc", 333));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                .append("Меню." + System.lineSeparator())
                .append("0. Добавить новую заявку." + System.lineSeparator())
                .append("1. Показать список всех заявок." + System.lineSeparator())
                .append("2. Редактировать заявку." + System.lineSeparator())
                .append("3. Удалить заявку." + System.lineSeparator())
                .append("4. Найти заявку по ID." + System.lineSeparator())
                .append("5. Найти заявку по названию." + System.lineSeparator())
                .append("6. Выйти из программы." + System.lineSeparator())
                .append("test name1 описание " + item1.getId() + System.lineSeparator())
                .append("test name2 desc " + item2.getId() + System.lineSeparator())
                .append("Меню." + System.lineSeparator())
                .append("0. Добавить новую заявку." + System.lineSeparator())
                .append("1. Показать список всех заявок." + System.lineSeparator())
                .append("2. Редактировать заявку." + System.lineSeparator())
                .append("3. Удалить заявку." + System.lineSeparator())
                .append("4. Найти заявку по ID." + System.lineSeparator())
                .append("5. Найти заявку по названию." + System.lineSeparator())
                .append("6. Выйти из программы." + System.lineSeparator())
                .toString()
        ));
    }
    @Test
    public void whenFindById() throws  InterruptedException {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "описание", 222));
        Thread.sleep(1000L); // без задержки ID одинаковый получается так как он генерируется от времени в миллисекундах.
        Item item2 = tracker.add(new Item("test name2", "desc", 333));
        Input input = new StubInput(new String[]{"4", item2.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                .append("Меню." + System.lineSeparator())
                .append("0. Добавить новую заявку." + System.lineSeparator())
                .append("1. Показать список всех заявок." + System.lineSeparator())
                .append("2. Редактировать заявку." + System.lineSeparator())
                .append("3. Удалить заявку." + System.lineSeparator())
                .append("4. Найти заявку по ID." + System.lineSeparator())
                .append("5. Найти заявку по названию." + System.lineSeparator())
                .append("6. Выйти из программы." + System.lineSeparator())
                .append("Имя заявки с ID - " + item2.getId() + ": test name2" + System.lineSeparator())
                .append("Меню." + System.lineSeparator())
                .append("0. Добавить новую заявку." + System.lineSeparator())
                .append("1. Показать список всех заявок." + System.lineSeparator())
                .append("2. Редактировать заявку." + System.lineSeparator())
                .append("3. Удалить заявку." + System.lineSeparator())
                .append("4. Найти заявку по ID." + System.lineSeparator())
                .append("5. Найти заявку по названию." + System.lineSeparator())
                .append("6. Выйти из программы." + System.lineSeparator())
                .toString()
        ));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name1", "описание", 222));
        Item item2 = tracker.add(new Item("test name2", "desc", 333));
        Input input = new StubInput(new String[]{"5", item2.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(new StringBuilder()
                .append("Меню." + System.lineSeparator())
                .append("0. Добавить новую заявку." + System.lineSeparator())
                .append("1. Показать список всех заявок." + System.lineSeparator())
                .append("2. Редактировать заявку." + System.lineSeparator())
                .append("3. Удалить заявку." + System.lineSeparator())
                .append("4. Найти заявку по ID." + System.lineSeparator())
                .append("5. Найти заявку по названию." + System.lineSeparator())
                .append("6. Выйти из программы." + System.lineSeparator())
                .append("Имя заявки: " + item2.getName() + " . Описание заявки: " + item2.getDesc() + System.lineSeparator())
                .append("Меню." + System.lineSeparator())
                .append("0. Добавить новую заявку." + System.lineSeparator())
                .append("1. Показать список всех заявок." + System.lineSeparator())
                .append("2. Редактировать заявку." + System.lineSeparator())
                .append("3. Удалить заявку." + System.lineSeparator())
                .append("4. Найти заявку по ID." + System.lineSeparator())
                .append("5. Найти заявку по названию." + System.lineSeparator())
                .append("6. Выйти из программы." + System.lineSeparator())
                .toString()
        ));
    }
}
