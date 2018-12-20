package ru.job4j.department;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class DepartmentTest {

    @Test
    public void whenAddDepartment() {
        Department department = new Department();
        department.addDepartment("K1\\SK1\\SSK2");
        ArrayList<String> except = new ArrayList<>(Arrays.asList("K1", "K1\\SK1", "K1\\SK1\\SSK2"));
        assertThat(department.getDepartments(), is(except));
    }

    @Test
    public void whenAscendingSort() {
        Department department = new Department();
        department.addDepartment("K2\\SK1");
        department.addDepartment("K1\\SK1\\SSK2");
        department.ascendingSort();
        ArrayList<String> except = new ArrayList<>(Arrays.asList("K1", "K1\\SK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1"));
        assertThat(department.getDepartments(), is(except));
    }

    @Test
    public void whenDescendingSort() {
        Department department = new Department();
        department.addDepartment("K2\\SK1\\SSK2");
        department.addDepartment("K1\\SK1\\SSK2");
        department.descendingSort();
        ArrayList<String> except = new ArrayList<>(Arrays.asList(
                    "K2", "K2\\SK1", "K2\\SK1\\SSK2", "K1", "K1\\SK1", "K1\\SK1\\SSK2")
            );
        assertThat(department.getDepartments(), is(except));
    }
}
