package ru.job4j.inpututput.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArchiverTest {

    @Test
    public void when() throws IOException {
        Archiver archiver = new Archiver();
        String suffix = "junior_chapter_001";
        StringBuilder dir = new StringBuilder();
        dir.append(System.getProperty("user.dir"));
        dir.delete(dir.toString().length() - 1 - suffix.length(), dir.toString().length());
        archiver.toZip(dir.toString(), List.of("class"));
    }

    @Test
    public void when2() throws IOException {
        Archiver2 archiver2 = new Archiver2();
        String suffix = "junior_chapter_001";
        StringBuilder dir = new StringBuilder();
        dir.append(System.getProperty("user.dir"));
        dir.delete(dir.toString().length() - 1 - suffix.length(), dir.toString().length());
        archiver2.toZip(dir.toString(), List.of("class", "java", "xml"));
    }
}
