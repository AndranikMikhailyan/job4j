package ru.job4j.inpututput.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArchiverTest {

    @Test
    public void when2() throws IOException {
        Archiver2 archiver2 = new Archiver2();
        String suffix = "junior_chapter_001";
        StringBuilder dir = new StringBuilder();
        dir.append(System.getProperty("user.dir"));
        dir.delete(dir.toString().length() - 1 - suffix.length(), dir.toString().length());
        archiver2.toZip(dir.toString(), "temp.zip", List.of("class", "java", "xml"));
    }
}
