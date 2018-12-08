package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            StringBuilder personInfo = new StringBuilder();
            personInfo.append(person.getName() + " ");
            personInfo.append(person.getSurname() + " ");
            personInfo.append(person.getAddress() + " ");
            personInfo.append(person.getPhone());
            if (personInfo.toString().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
