package ru.job4j.io.socket.server;

import java.io.IOException;
import java.util.function.Supplier;

/**
 * При реализации сервера, необходимо добавить поле храняшее директорию.
 * Для вызова метода со стороны клиента можно воспользоваться диспатч патерном.
 */

public interface ServerManager {

    /**
     * Метод запускает сервер.
     */
    void start(String path) throws IOException;

    /**
     * Метод выводит список содержимого текущей папки.
     */
    Supplier<Boolean> getContents();

    /**
     * Метод переходит в указанную папку.
     */
    Supplier<Boolean> goToFolder();

    /**
     * Метод переходит в родительскую папку.
     */
    Supplier<Boolean> goBack();

    /**
     * Метод находит нужный файл и копирует его содержимое в выходной поток.
     */
    Supplier<Boolean> download();

    /**
     * Метод принимает имя файла, создает новый файл в директории и копирует в него байты из входного потока.
     */
    Supplier<Boolean> upload();
}
