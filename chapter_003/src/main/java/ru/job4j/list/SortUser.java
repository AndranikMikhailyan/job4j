package ru.job4j.list;

import java.util.*;
import java.util.stream.Collectors;

public class SortUser {
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    public List<User> sortNameLength(List<User> list) {
        return list.stream().sorted(
                (o1, o2) -> Integer.compare(o1.getName().length(), o2.getName().length()))
                .collect(Collectors.toList());
    }

    public List<User> sortByAllFields(List<User> list) {
        return list.stream().sorted(
                (o1, o2) -> 0 != o1.getName().compareTo(o2.getName())
                        ? o1.getName().compareTo(o2.getName()) : o1.compareTo(o2))
                .collect(Collectors.toList());
    }


}

