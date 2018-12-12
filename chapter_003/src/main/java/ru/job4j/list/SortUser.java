package ru.job4j.list;

import java.util.*;

public class SortUser  {
    public Set<User> sort(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.compareTo(o2);
            }
        });
        TreeSet<User> userTreeSet = new TreeSet<>();
        for (User user : list) {
            userTreeSet.add(user);
        }
        return userTreeSet;
    }
}
