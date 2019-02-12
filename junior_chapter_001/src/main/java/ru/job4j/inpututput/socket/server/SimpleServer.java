package ru.job4j.inpututput.socket.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args) throws IOException {
        System.out.println("Ожидаю подключение ...");
        ServerSocket serverSocket = new ServerSocket(80);
        Socket socket = serverSocket.accept();
        try(InputStream in = socket.getInputStream();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            out.println("Hello\nWorld");
        }
    }
}
