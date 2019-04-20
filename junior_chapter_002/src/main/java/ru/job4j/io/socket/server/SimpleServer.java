package ru.job4j.io.socket.server;

import java.io.IOException;
import java.nio.file.*;

public class SimpleServer {

    public static void main(String[] args) throws IOException {
        try {
            Path src = Paths.get("C:\\projects\\temp\\src.txt");
            Path target = Paths.get("C:\\projects\\temp\\target.txt");
            Files.copy(src, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        }
    }
}
