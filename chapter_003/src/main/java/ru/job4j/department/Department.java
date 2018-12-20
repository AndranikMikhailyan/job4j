package ru.job4j.department;

import java.util.*;

public class Department {

    private List<String> departments = new ArrayList<>();

    public List<String> getDepartments() {
        return departments;
    }

    public void addDepartment(String department) {
        String[] split = department.split("\\\\");
        StringBuilder current = new StringBuilder();
        for (String s : split) {
            current = current.append(s);
            if (!departments.contains(s)) {
                departments.add(current.toString());
            }
            current = current.append("\\");
        }
    }

    public List<String> ascendingSort() {
         Collections.sort(this.departments, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
         return departments;
    }

    public List<String> descendingSort() {
        Comparator<String> lengthComp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };
        Comparator<String> stringComp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = 0;
                if (o1.length() == o2.length()) {
                    result = o2.compareTo(o1);
                } else {
                    if (o2.compareTo(o1) < 0 && Integer.compare(o1.length(), o2.length()) < 0) {
                        result = -1;
                    } else {
                        result = 1;
                    }
                }
                return result;
            }
        };
         Collections.sort(this.departments, stringComp);
         return departments;
    }
}
