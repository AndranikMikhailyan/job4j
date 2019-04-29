package ru.job4j.sql.trackersql;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSQLTest {

    @Test
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.init(), is(true));
    }

//    @Test
//    public void add() {
//    }
//
//    @Test
//    public void replace() {
//    }
//
//    @Test
//    public void delete() {
//    }
//
//    @Test
//    public void findAll() {
//    }
//
//    @Test
//    public void findByName() {
//    }
//
//    @Test
//    public void findById() {
//    }
//
//    @Test
//    public void close() {
//    }
}