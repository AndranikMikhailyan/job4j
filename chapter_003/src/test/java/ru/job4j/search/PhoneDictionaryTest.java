package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Ivan", "Ivanov", "89996665588", "Moscow")
        );
        var persons = phones.find("Ivan");
        assertThat(persons.iterator().next().getSurname(), is("Ivanov"));
    }
}
