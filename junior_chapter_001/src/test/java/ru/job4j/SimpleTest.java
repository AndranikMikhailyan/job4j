package ru.job4j;

import java.io.*;

public class SimpleTest {

    public static void main(String[] args) throws IOException {

        Writer writer2 = new FileWriter("D:\\Копия симпл мапа.txt");

        Reader reader = new FileReader("C:\\projects\\job4j\\junior_chapter_001\\src\\main\\java\\ru\\job4j\\map\\SimpleHashMap.java");
        int i;
        while ((i = reader.read()) != -1) {
            writer2.write(i);
        }
        writer2.flush();
        writer2.close();

        Reader reader1 = new FileReader("D:\\Копия симпл мапа.txt");
        int i1;
        while ((i1 = reader1.read()) != -1) {
            System.out.print((char) i1);
        }
    }
}
