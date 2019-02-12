package ru.job4j.inpututput.socket.client;

import java.io.File;

public interface ClientManager {

    /**
     * Метод подключается к серверу.
     */
    void start();

    /**
     * Метод выводит в консоль список содержимого текущей папки на сервере.
     */
    void getContents();

    /**
     * Метод переходит в указанную папку на сервере.
     * @param folderName - имя папки в которую надо перейти
     */
    void goToFolder(String folderName);

    /**
     * Метод переходит в родительскую папку на сервере.
     */
    void goBack();

    /**
     * Метод отправляет имя файла, который требуется найти. Создает новый файл, и копирует в него байты из входного потока.
     * @param fileName - имя файла.
     */
    void download(String fileName);

    /**
     * Метод передает имя файла серверу,  и копирует байты из файла в входной поток.
     * @param file - файл загружаемый на сервер.
     */
    void upload(File file);
}
