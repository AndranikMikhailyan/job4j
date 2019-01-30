package ru.job4j.inpututput.io;

import java.io.*;
import java.util.Random;

public class ConsolChat {

    public static void main(String[] args) throws IOException {
        File file = new File(System.getProperty("user.dir") + "/junior_chapter_001/src/main/resources/Ansvers.txt");
        RandomAccessFile ansvers = new RandomAccessFile(file, "r");
        Random rnd = new Random();
        BufferedReader userWrite = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите фразу");
        String phrase = null;
        do {
            phrase = userWrite.readLine();
            System.out.println("Я написал: " + phrase);
            if (phrase.equals("стоп")) {
                System.out.println("бот в ожидании слова \"продолжить\"");
                do {
                    phrase = userWrite.readLine();
                    System.out.println("Я написал: " + phrase);
                    if (phrase.equals("закончить")) {
                        break;
                    }
                } while (!phrase.equals("продолжить"));
                if (!phrase.equals("закончить")) {
                    ansvers.seek(rnd.nextInt((int) ansvers.length()));
                    ansvers.readLine();
                    System.out.println("Бот продолжает отвечать и написал: " + ansvers.readLine());
                }
            } else if (!phrase.equals("закончить")) {
                ansvers.seek(rnd.nextInt((int) ansvers.length()));
                ansvers.readLine();
                System.out.println("Бот написал: " + ansvers.readLine());
            }
        } while (!phrase.equals("закончить"));
    }
}
