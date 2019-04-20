package ru.job4j.io.socket.client;

import com.google.common.base.Joiner;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Supplier;

public class ClientManagerImpl implements ClientManager {

    private Socket socket;
    private HashMap<Integer, Supplier<Boolean>> methods;
    private BufferedReader fromServer;
    private PrintWriter outToServer;
    private Scanner console;

    public ClientManagerImpl(Socket socket) throws IOException {
        this.socket = socket;
        this.methodInit();
        fromServer = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), "UTF-8"));
        outToServer = new PrintWriter(this.socket.getOutputStream(), true);
        console = new Scanner(System.in);
    }

    /**
     * Метод подключается к серверу.
     */
    @Override
    public void start() {
        this.menu();
        String comand;
        do {
            System.out.println("Введите команду ...");
            comand = console.nextLine();
            outToServer.println(comand);
            if (!comand.equals("0")) {
                this.methods.get(Integer.parseInt(comand)).get();
            }
        } while (!comand.equals("0"));
    }

    private void menu() {
        System.out.println(Joiner
                .on(System.lineSeparator())
                .join("Вы подключены к серверу",
                        "Для взаимодействия с сервером используйте ключи",
                        "\"1\" - получить содержимое текущей папки",
                        "\"2\" - перейти в папку",
                        "\"3\" - вернуться назад",
                        "\"4\" - скачать файл с сервера",
                        "\"5\" - загрузить файл на сервер",
                        "\"0\" - завершить работу")
        );
    }

    /**
     * Метод выводит в консоль список содержимого текущей папки на сервере.
     */
    @Override
    public Supplier<Boolean> getContents() {
        return () -> {
            try {
                String msg;
                do {
                    msg = fromServer.readLine();
                    if (!msg.isEmpty()) {
                        System.out.println(msg);
                    }
                } while (!msg.isEmpty());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        };
    }

    /**
     * Метод переходит в указанную папку на сервере.
     */
    @Override
    public Supplier<Boolean> goToFolder() {
        return () -> {
            System.out.println("Введите название папки ...");
            outToServer.println(console.nextLine());
            this.getContents().get();
            System.out.println("Метод готуфолдер завершен");
            return true;
        };
    }

    /**
     * Метод переходит в родительскую папку на сервере.
     */
    @Override
    public Supplier<Boolean> goBack() {
        return () -> {
            this.getContents().get();
            return true;
        };
    }

    /**
     * Метод отправляет имя файла, который требуется найти. Создает новый файл, и копирует в него байты из входного потока.
     */
    @Override
    public Supplier<Boolean> download() {
        return () -> {
            System.out.println("Введите название файла ...");
            String fileName = console.nextLine();
            outToServer.println(fileName);
            try (BufferedInputStream inputStream = new BufferedInputStream(socket.getInputStream())) {
                System.out.println("Начало скачивания ...");
                Path file = Paths.get(System.getProperty("user.home") + "/" + fileName);
                FileOutputStream fis = new FileOutputStream(file.toFile());
                byte[] bytes = new byte[8192];
                int length;
                do {
                    length = inputStream.read(bytes);
                    System.out.println(length);
                    fis.write(bytes, 0, length);
                } while (length == bytes.length);
                fis.close();
                System.out.println("Конец скачивания ...");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        };
    }

    /**
     * Метод передает имя файла серверу,  и копирует байты из файла в входной поток.
     */
    @Override
    public Supplier<Boolean> upload() {
        return () -> {
            return true;
        };
    }

    private void methodInit() {
        methods = new HashMap<>();
        methods.put(1, this.getContents());
        methods.put(2, this.goToFolder());
        methods.put(3, this.goBack());
        methods.put(4, this.download());
        methods.put(5, this.upload());
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8080);
        ClientManagerImpl clientManager = new ClientManagerImpl(socket);
        clientManager.start();
    }
}
