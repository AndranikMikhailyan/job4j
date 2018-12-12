package ru.job4j.list;

import java.util.*;

public class SortUser {
    public Set<User> sort(List<User> list) {
        TreeSet<User> userTreeSet = new TreeSet<>();
        for (User user : list) {
            userTreeSet.add(user);
        }
        return userTreeSet;
    }
}

