package ru.job4j.collections;

public class User implements Comparable<User> {
    private String name;
    private int age;
    private int id;
    private String city;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

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

    @Override
    public int compareTo(User o) {
        return this.age - o.age;
    }
}
