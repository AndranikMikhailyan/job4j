package ru.job4j.list;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> userMap = new HashMap<>();
        list.forEach(user -> userMap.put(user.getId(), user));
        return userMap;
    }
}
