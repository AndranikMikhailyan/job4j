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
        archiver.toZip("C:\\projects\\job4j", List.of("class"));
    }
}
