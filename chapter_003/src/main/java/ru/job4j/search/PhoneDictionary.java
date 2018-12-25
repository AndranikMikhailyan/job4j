package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public List<Person> find(String key) {
        List<Person> result = persons.stream().filter(
                            person -> person.getName().contains(key)
                                || person.getSurname().contains(key)
                                || person.getAddress().contains(key)
                                || person.getPhone().contains(key))
                            .collect(Collectors.toList());
        return result;
    }
}
