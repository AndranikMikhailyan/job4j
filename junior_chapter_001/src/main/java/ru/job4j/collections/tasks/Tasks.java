package ru.job4j.collections.tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tasks {

    public boolean containSameChar(String first, String second) {
        boolean result = true;
        if (first.length() == second.length()) {
            HashMap<Character, ArrayList<Character>> chars = new HashMap<>();
            for (char[] ch : new char[][] {first.toCharArray(), second.toCharArray()}) {
                for (char c : ch) {
                    if (!chars.containsKey(c)) {
                        ArrayList<Character> list = new ArrayList<>();
                        list.add(c);
                        chars.put(c, list);
                    } else {
                        chars.get(c).add(c);
                    }
                }
            }
            for (List<Character> value : chars.values()) {
                if (value.size() % 2 != 0) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;
    }


}
