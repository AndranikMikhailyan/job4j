package ru.job4j.inpututput.io;

import org.junit.Test;

import java.io.*;

public class DeleteWordsTest {

    @Test
    public void whenDeleteWorld() throws IOException {
        char[] c = ("Hello world what then\n" + "1\n" + "\n" + "no").toCharArray();
        Writer out = new CharArrayWriter();
        Reader in = new CharArrayReader(c);
        DeleteWords deleteWords = new DeleteWords();
        deleteWords.dropAbuses(in, out, new  String[]{"Hello", "1"});
    }
}
