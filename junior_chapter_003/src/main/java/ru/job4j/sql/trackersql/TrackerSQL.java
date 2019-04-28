package ru.job4j.sql.trackersql;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;


/**
 * Класс реализет хранение заявок в базе данных и манипулирование ими.
 * @author Andranik
 * @since 1.0
 */
public class TrackerSQL implements ITracker, AutoCloseable {

    /**
     * Соединение с базой данных.
     */
    private Connection connection;

    /**
     * Метод инициализирует переменную "connection".
     * @return возвращает true - если соединение получено, false - если соединение не получено.
     */
    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
              config.getProperty("url"),
              config.getProperty("username"),
              config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        this.tablesInit(this.connection);
        return this.connection != null;
    }

    /**
     * Метод создает таблицы в базе если их нет.
     */
    private void tablesInit(Connection connection) {
        try (Statement st = connection.createStatement()) {
            st.executeQuery("create table if not exists item("
                    + "  item_id serial primary key,"
                    + "  name varchar(200) not null,"
                    + "  description varchar(200) not null,"
                    + "  created timestamp)");
            st.executeQuery("create table if not exists comment("
                    + "  comment_id serial primary key,"
                    + "  comment varchar(3000),"
                    + "  item_id int references item(item_id))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Item add(Item item) {
        return null;
    }

    @Override
    public boolean replace(String id, Item item) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public List<Item> findByName(String key) {
        return null;
    }

    @Override
    public Item findById(String id) {
        return null;
    }

    @Override
    public void close() throws Exception {

    }

    public static void main(String[] args) {
        TrackerSQL trackerSQL = new TrackerSQL();
        trackerSQL.init();
    }
}
