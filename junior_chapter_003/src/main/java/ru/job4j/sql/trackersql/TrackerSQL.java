package ru.job4j.sql.trackersql;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
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
            st.execute("create table if not exists item("
                    + "  item_id serial primary key,"
                    + "  name varchar(200) not null,"
                    + "  description varchar(200) not null,"
                    + "  created timestamp)");
            st.execute("create table if not exists comment("
                    + "  comment_id serial primary key,"
                    + "  comment varchar(3000),"
                    + "  item_id int references item(item_id))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод добавляет заявку в базу данных.
     * @param item Заявка которую необходимо добавить.
     * @return Возвращает объект заявки.
     */
    @Override
    public Item add(Item item) {
        try (PreparedStatement st = this.connection
                .prepareStatement("insert into item (name, description, created) values (?, ?, ?)")) {
            st.setString(1, item.getName());
            st.setString(2, item.getDesc());
            st.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * Метод меняет заявку по номеру id на новую заявку item.
     * @param id Уникальный номер заменяемой заявки
     * @param item Новая заявка в замен существующей по "id" заявке.
     * @return возвращает true если замена произошла, false если нет.
     */
    @Override
    public boolean replace(String id, Item item) {
        try (PreparedStatement st = this.connection
                .prepareStatement("update item set (name, description, created) = (?, ?, ?) where item_id=" + Integer.parseInt(id))) {
        st.setString(1, item.getName());
        st.setString(2, item.getDesc());
        st.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
        st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Метод удаляет заявку из базы данных.
     * @param id Уникальный номер удаляемой заявки.
     * @return возвращает true если удаление произошло, false если нет.
     */
    @Override
    public boolean delete(String id) {
        try (PreparedStatement st = connection.prepareStatement("delete from item where item_id = ?")) {
            st.setInt(1, Integer.parseInt(id));
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Метод делает выборку из базы данных и на ее основе создает список заявок.
     * @return Возвращает список объектов заявок.
     */
    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from item")) {
            while (rs.next()) {
                items.add(new Item(rs.getString(2), rs.getString(3), rs.getTimestamp(4).getTime()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    /**
     * Метод делает выборку с одинаковым именем заявки из базы данных и на ее основе создает список заявок.
     * @return Возвращает список объектов заявок с одинаковым именем.
     */
    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from item where name = " + key)) {
            while (rs.next()) {
                items.add(new Item(rs.getString(2), rs.getString(3), rs.getTimestamp(4).getTime()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    /**
     * Метод находи заявку в базе и возвращает объект построенный да ее данных.
     * @param id Уникальный номер искомой заявки.
     * @return Возвращает объек заявки.
     */
    @Override
    public Item findById(String id) {
        Item item = null;
        try (Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from item where item_id=" + Integer.parseInt(id))) {
            while (rs.next()) {
                item = new Item(rs.getString(2), rs.getString(3), rs.getTimestamp(4).getTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * Метод закрывает соединение с базой.
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        connection.close();
    }
}
