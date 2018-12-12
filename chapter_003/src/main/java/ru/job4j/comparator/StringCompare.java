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
        while (result == 0 && !(o1.length() == count && o2.length() == count)) {
            if (o1.length() == count && o1.length() != o2.length()) {
                result--;
            } else if (o2.length() == count && o1.length() != o2.length()) {
                result++;
            } else  {
                result = o1.charAt(count) - o2.charAt(count);
                count++;
            }
        }
        return result;
    }
}
