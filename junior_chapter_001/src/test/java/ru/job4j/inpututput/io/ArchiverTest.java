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
        System.out.println(System.getProperties().toString());
        File file = new File("job4j");
        System.out.println(file.getParent());
        archiver.toZip("C:/projects/job4j", List.of("class"));
    }

    @Test
    public void when2() throws IOException {
        Archiver2 archiver2 = new Archiver2();
        archiver2.toZip("C:/projects/job4j", List.of("class", "java", "xml"));
    }
}
