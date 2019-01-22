package ru.job4j.inpututput.io;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DeleteWords {

    public void dropAbuses(Reader in, Writer out, String[] abuse) throws IOException {
        List<String> abuseWords = Arrays.stream(abuse).collect(Collectors.toList());
        BufferedReader brIn = new BufferedReader(in);
        String sours;
        while ((sours = brIn.readLine()) != null) {
            String[] words = sours.split(" ");
            Arrays.stream(words).forEach(word -> {
               if (!abuseWords.contains(word)) {
                   try {
                       out.write(word + " ");
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
            });
        }
        brIn.close();
        out.flush();
        out.close();
    }
}
