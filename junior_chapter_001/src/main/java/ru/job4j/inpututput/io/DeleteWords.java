package ru.job4j.inpututput.io;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DeleteWords {

    public void dropAbuses(Reader in, Writer out, String[] abuse) throws IOException {
        List<String> abuseList = Arrays.stream(abuse).collect(Collectors.toList());
        StringBuilder word = new StringBuilder();
        int ch;
        while ((ch = in.read()) != -1) {
            char chr = (char) ch;
            if (chr != ' ') {
                word.append(chr);
            } else {
                if (!abuseList.contains(word.toString())) {
                    out.write(word.toString());
                    word.delete(0, word.toString().length());
                } else {
                    word.delete(0, word.toString().length());
                }
            }
        }
        out.flush();
        out.close();
        in.close();
    }
}
