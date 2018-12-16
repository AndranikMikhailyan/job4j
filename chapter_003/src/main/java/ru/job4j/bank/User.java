package ru.job4j.bank;

import java.util.Objects;

public class User implements Comparable<User> {

    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
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
        return passport == user.passport
                && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }

    @Override
    public int compareTo(User o) {
        return this.name.compareTo(o.name) != 0
                ? this.name.compareTo(o.name) : this.passport.compareTo(o.passport);
    }
}
