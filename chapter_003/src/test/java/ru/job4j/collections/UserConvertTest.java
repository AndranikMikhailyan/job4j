package ru.job4j.collections;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserConvertTest {
    @Test
    public void whenAddThreeUser() {
        UserConvert convert = new UserConvert();
        User user1 =  new User("Ivan", 101, "Moscow");
        User user2 =  new User("Roma", 102, "Moscow");
        User user3 =  new User("Dasha", 103, "Moscow");
        List<User> list = List.of(user1, user2, user3);
        HashMap<Integer, User> result = convert.process(list);
        Map<Integer, User> expect = Map.of(101, user1, 102, user2, 103, user3);
        assertThat(result, is(expect));
    }
}
