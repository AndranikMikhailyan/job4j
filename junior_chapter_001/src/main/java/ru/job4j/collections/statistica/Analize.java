package ru.job4j.collections.statistica;

import java.util.HashMap;
import java.util.List;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info result = new Info();

        int beforeSize = previous.size();

        HashMap<Integer, User> allUsers = new HashMap<>();
        for (User user : current) {
            allUsers.put(user.getId(), user);
        }

        for (User user : previous) {
            if (!allUsers.containsKey(user.getId())) {
                result.deleted++;
            } else if (!allUsers.get(user.getId()).getName().equals(user.getName())) {
                result.changed++;
            }
            allUsers.put(user.getId(), user);
        }

        int newSize = allUsers.size();
        result.added = Math.max(0, newSize - beforeSize);


        return result;
    }

    static class Info {
        int added = 0;
        int changed = 0;
        int deleted = 0;
    }
}
