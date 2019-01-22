package ru.job4j.inpututput.io;

import org.junit.Test;

import java.io.*;

public class DeleteWordsTest {

    @Test
    public void whenDeleteWorld() throws IOException {
        Writer out = new FileWriter(
                "C:\\projects\\job4j\\junior_chapter_001\\src\\test\\java\\ru\\job4j\\inpututput\\io\\Destination.txt"
        );
        Reader in = new FileReader(
                "C:\\projects\\job4j\\junior_chapter_001\\src\\test\\java\\ru\\job4j\\inpututput\\io\\Sours.txt"
        );
        DeleteWords deleteWords = new DeleteWords();
        deleteWords.dropAbuses(in, out, new  String[]{"Hello"});
    }
}
