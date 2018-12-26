package ru.job4j.student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentsGroup {

    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(student -> Stream.ofNullable(student))
                .sorted()
                .takeWhile(student -> student.getScore() > bound).collect(Collectors.toList());
    }
}
