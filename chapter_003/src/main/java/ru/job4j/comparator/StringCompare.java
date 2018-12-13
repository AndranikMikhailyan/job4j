package ru.job4j.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int count = 0;
        int result = 0;
        while (result == 0 && count < o1.length() && count < o2.length()) {
            result =Integer.compare(o1.charAt(count), o2.charAt(count));
            count++;
        }
        if (result == 0) {
            result = Integer.compare(o1.length(), o2.length());
        }

        return result;
    }
}
