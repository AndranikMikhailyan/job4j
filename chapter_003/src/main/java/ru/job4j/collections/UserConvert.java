package ru.job4j.collections;

import java.util.HashMap;
import java.util.List;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> userMap = new HashMap<>();
        list.forEach(user -> userMap.put(user.getId(), user));
        return userMap;
    }
}
