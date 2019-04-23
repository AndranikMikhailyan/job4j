package ru.job4j.sql;

import java.sql.*;


public class SQLStorage {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/job4j_junior";
        String username = "postgres";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement st = conn.prepareStatement("SELECT * FROM users as u where u.id = ?")) {
            st.setInt(1, 1);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(String.format("%s %s", rs.getString("login"), rs.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement st = conn.prepareStatement("insert into users (login, id_role) values (?, ?)")) {
            st.setString(1, "user1");
            st.setInt(2, 1);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement st = conn.prepareStatement("update users set login=? where id=?")) {
            st.setString(1, "roman");
            st.setInt(2, 5);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement st = conn.prepareStatement("delete from users where id=?")) {
            st.setInt(1, 5);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println(String.format("%s %s", rs.getString("login"), rs.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
