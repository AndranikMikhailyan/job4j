package ru.job4j.statistica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info result = new Info();
//        int previousLength = previous.size();
//        int currentLength = current.size();
//        previous.addAll(current);
//        HashMap<Integer, User> allUsers = new HashMap<>();
//        for (User user : previous) {
//            allUsers.put(user.getId(), user);
//        }
//        int allUsersSize = allUsers.size();
//        result.added = Math.max(0, allUsersSize -  previousLength);
//        result.changed = Math.max(0, currentLength - result.added);
//        result.deleted = Math.max(0, allUsersSize - result.added - result.changed);

//        HashMap<Integer, User> previousMap = new HashMap<>();
//        for (User user : previous) {
//            previousMap.put(user.getId(), user);
//        }
//        HashMap<Integer, User> currentMap = new HashMap<>();
//        for (User user : current) {
//            currentMap.put(user.getId(), user);
//        }
//        for (Map.Entry<Integer, User> pair : previousMap.entrySet()) {
//            if (!current.contains(pair.getKey())) {
//                result.deleted++;
//        }

        for (User user : previous) {
            if (!current.contains(user)) {
                result.deleted++;
            } else if (current.contains(user)
                    && current.get(current.indexOf(user)).nameChanged()) {
                result.changed++;
            }
        }
        for (User user : current) {
            if (!previous.contains(user)) {
                result.added++;
            }
        }

//        for (User curUser : current) {
//            for (User prevUser : previous) {
//                if (!curUser.getName().equals(prevUser.getName())
//                        && curUser.getId() != prevUser.getId()
//                        && curUser != prevUser) {
//                    result.added++;
//                }
//            }
//        }
//


        return result;
    }

    static class Info {
        int added = 0;
        int changed = 0;
        int deleted = 0;
    }
}
