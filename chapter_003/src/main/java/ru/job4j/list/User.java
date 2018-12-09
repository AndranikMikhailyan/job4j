package ru.job4j.list;

public class User {
    private String name;
    private int id;
    private String city;

    public User(String name, int id, String city) {
        this.name = name;
        this.id = id;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }
}
