package ru.job4j.inpututput.socket.server;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.HashMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ServerManagerImpl implements ServerManager {

    private final int port;
    private Path folder;
    private Socket server;
    private HashMap<Integer, Supplier<Boolean>> methods;
    private PrintWriter out;
    private BufferedReader in;
    BufferedOutputStream outputStream;

    public ServerManagerImpl(int port) {
        this.port = port;
    }

    /**
     * Метод запускает сервер.
     */
    @Override
    public void start(String path) throws IOException {
        this.folder = Paths.get(path);
        this.methodInit();
        System.out.println("Ожидается подключение ...");
        this.server = new ServerSocket(port).accept();
        out = new PrintWriter(this.server.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(this.server.getInputStream()));
        outputStream = new BufferedOutputStream(server.getOutputStream());
        try {
            int key;
            String str;
            do {
                System.out.println("Ожидание команды ...");
                str = in.readLine();
                System.out.println(str);
                key = Integer.parseInt(str);
                if (key != 0) {
                    methods.get(key).get();
                    System.out.println(server.isConnected());
                    System.out.println(in.readLine());
                }
                System.out.println("Команда выполнена");
            } while (key != 0);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    /**
     * Метод выводит список содержимого текущей папки.
     */
    @Override
    public Supplier<Boolean> getContents() {
        return () -> {
            try {
                System.out.println("Выполняется метод гетКонтент");
                StringBuilder files = new StringBuilder();
                files.append("- " + this.folder.getFileName() + System.lineSeparator());
                Files.list(this.folder).forEach(
                        path -> files.append("\t- " + path.getFileName() + System.lineSeparator())
                );
                out.println(files.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        };
    }

    /**
     * Метод переходит в указанную папку.
     */
    @Override
    public Supplier<Boolean> goToFolder() {
        return () -> {
            try {
                String folderName = in.readLine();
                this.folder = Paths.get(this.folder.toString() + "/" + folderName);
                this.getContents().get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        };

    }

    /**
     * Метод переходит в родительскую папку.
     */
    @Override
    public Supplier<Boolean> goBack() {
        return () -> {
            if (this.folder.getParent() != null) {
                this.folder = this.folder.getParent();
                this.getContents().get();
            } else {
                out.println("Вы в корневой папке");
                this.getContents().get();
            }
            return true;
        };
    }

    /**
     * Метод находит нужный файл и копирует его содержимое в выходной поток.
     */

    @Override
    public Supplier<Boolean> download() {
        return () -> {
            try  {
                String fileName = in.readLine();
                for (Path path : Files.list(this.folder).collect(Collectors.toList())) {
                    if (path.getFileName().toString().equals(fileName)) {
                        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path.toFile()));
                        byte[] bytes = new byte[8192];
                        int length;
                        while ((length = bis.read(bytes)) != -1) {
                            outputStream.write(bytes, 0, length);
                            outputStream.flush();
                        }
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        };
    }

    /**
     * Метод принимает имя файла, создает новый файл в директории и копирует в него байты из входного потока.
     */
    @Override
    public Supplier<Boolean> upload() {
        return () -> {
            try {
                String fileName = in.readLine();
                Path file = Paths.get(this.folder.toString() + System.getProperty("path.separator") + fileName);
                Files.copy((Path) in, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        ServerManagerImpl smi = new ServerManagerImpl(8080);
        smi.start("D:\\Andranik\\Трейдинг");
    }
}
