package ru.job4j.io;

import java.io.*;

public class ConsolChat {

    public static void main(String[] args) throws IOException {
        File file = new File(System.getProperty("user.dir") + "/junior_chapter_001/src/main/resources/Ansvers.txt");
        ChatDispatch chatDispatch = new ChatDispatch(file);
        BufferedReader userWrite = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите фразу");
        boolean exit = true;
        while (exit) {
            exit = chatDispatch.read(userWrite.readLine());
        }
    }
}
