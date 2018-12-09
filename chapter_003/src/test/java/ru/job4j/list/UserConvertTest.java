package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserConvertTest {
    @Test
    public void whenAddThreeUser() {
        UserConvert convert = new UserConvert();
        User user1 =  new User("Ivan", 101, "Moscow");
        User user2 =  new User("Roma", 102, "Moscow");
        User user3 =  new User("Dasha", 103, "Moscow");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        HashMap<Integer, User> result = convert.process(list);
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(101, user1);
        expect.put(102, user2);
        expect.put(103, user3);
        assertThat(result, is(expect));
    }
}
