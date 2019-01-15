package ru.job4j.statistica;

import java.util.Objects;

public class User {

    private String name;
    private String oldName;
    private int id;

    public User(String name, int id) {
        this.name = name;
        this.oldName = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.oldName = this.name;
        this.name = name;
    }

    public boolean nameChanged() {
        return !name.equals(oldName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id
                && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
