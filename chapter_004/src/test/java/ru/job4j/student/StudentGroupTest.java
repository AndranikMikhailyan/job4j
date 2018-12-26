package ru.job4j.student;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class StudentGroupTest {

    @Test
    public void whenLevelOf80() {
        StudentsGroup stdGroup = new StudentsGroup();
        Student st1 = new Student("Ivan", 50);
        Student st2 = new Student("Alex", 66);
        Student st3 = null;
        Student st4 = new Student("Anthony", 75);
        Student st5 = new Student("John", 90);
        Student st6 = null;
        Student st7 = new Student("Gordon", 91);
        Student st8 = new Student("Nik", 94);
        List<Student> except = Arrays.asList(st8, st7, st5);
        List<Student> result = stdGroup.levelOf(
                Arrays.asList(st1, st2, st3, st4, st5, st6, st7, st8), 80);
        assertThat(result, is(except));
    }
}
