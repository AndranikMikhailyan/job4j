package ru.job4j.collections.generic;

import org.junit.Test;
import ru.job4j.collections.generic.User;
import ru.job4j.collections.generic.UserStore;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserStoreTest {

    @Test
    public void whenAddObjectThenRoleStoreHasObject() {
        UserStore userStore = new UserStore(10);
        User user = new User("A0001");
        userStore.add(user);
        assertThat(userStore.findById("A0001"), is(user));
    }

    @Test
    public void whenRepleceObjectThenTrue() {
        UserStore userStore = new UserStore(10);
        User user1 = new User("A0001");
        User user2 = new User("A0002");
        userStore.add(user1);
        assertThat(userStore.replace("A0001", user2), is(true));
    }

    @Test
    public void whenDeleteObjectThenTrue() {
        UserStore userStore = new UserStore(10);
        User user = new User("A0001");
        userStore.add(user);
        assertThat(userStore.delete("A0001"), is(true));
    }

    @Test
    public void whenFindByIdThenReturnObject() {
        UserStore userStore = new UserStore(10);
        User user = new User("A0001");
        userStore.add(user);
        assertThat(userStore.findById("A0001"), is(user));
    }

    @Test
    public void whenRoleStoreIsEmptyThenReturnNull() {
        UserStore userStore = new UserStore(10);
        User user = new User("A0001");
        assertNull(userStore.findById("A0001"));
    }
}
