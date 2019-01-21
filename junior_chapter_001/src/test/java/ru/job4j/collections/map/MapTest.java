package ru.job4j.collections.map;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MapTest {

    @Test
    public void when() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDateFormat.parse("20/04/1980");
        Calendar birthday = Calendar.getInstance();
        birthday.setTime(date);
        User first = new User("Ivan", 2, birthday);
        User second = new User("Ivan", 2, birthday);
        Map<User, Object> map = new HashMap<>();
        map.put(first, first);
        map.put(second, second);
        System.out.println(map);
    }
}
