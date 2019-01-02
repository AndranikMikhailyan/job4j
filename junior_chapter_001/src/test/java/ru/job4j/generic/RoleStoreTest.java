package ru.job4j.generic;

import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class RoleStoreTest {

    @Test
    public void whenAddObjectThenRoleStoreHasObject() {
        RoleStore roleStore = new RoleStore(10);
        Role role = new Role("A0001");
        roleStore.add(role);
        assertThat(roleStore.findById("A0001"), is(role));
    }

    @Test
    public void whenRepleceObjectThenTrue() {
        RoleStore roleStore = new RoleStore(10);
        Role role1 = new Role("A0001");
        Role role2 = new Role("A0002");
        roleStore.add(role1);
        assertThat(roleStore.replace("A0001", role2), is(true));
    }

    @Test
    public void whenDeleteObjectThenTrue() {
        RoleStore roleStore = new RoleStore(10);
        Role role1 = new Role("A0001");
        roleStore.add(role1);
        assertThat(roleStore.delete("A0001"), is(true));
    }

    @Test
    public void whenFindByIdThenReturnObject() {
        RoleStore roleStore = new RoleStore(10);
        Role role1 = new Role("A0001");
        roleStore.add(role1);
        assertThat(roleStore.findById("A0001"), is(role1));
    }

    @Test
    public void whenRoleStoreIsEmptyThenReturnNull() {
        RoleStore roleStore = new RoleStore(10);
        Role role1 = new Role("A0001");
        assertNull(roleStore.findById("A0001"));
    }
}
