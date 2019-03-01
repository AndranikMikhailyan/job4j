package ru.job4j.inpututput.socket.client;

import java.io.File;
import java.util.function.Supplier;

public interface ClientManager {

    /**
     * Метод подключается к серверу.
     */
    void start();

    /**
     * Метод выводит в консоль список содержимого текущей папки на сервере.
     */
    Supplier<Boolean> getContents();

    /**
     * Метод переходит в указанную папку на сервере.
     */
    Supplier<Boolean> goToFolder();

    /**
     * Метод переходит в родительскую папку на сервере.
     */
    Supplier<Boolean> goBack();

    /**
     * Метод отправляет имя файла, который требуется найти. Создает новый файл, и копирует в него байты из входного потока.
     */
    Supplier<Boolean> download();

    /**
     * Метод передает имя файла серверу,  и копирует байты из файла в входной поток.
     */
    Supplier<Boolean> upload();
}
