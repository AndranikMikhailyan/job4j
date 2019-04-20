package ru.job4j.io.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Server {

    private final Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void start() throws IOException {
        String ask;
        try (PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()))) {
            do {
                System.out.println("Ожидание команды ...");
                ask = in.readLine();
                System.out.println(ask);
                if ("привет".equals(ask.toLowerCase())) {
                    out.println("Привет, дорогой друг, я oracle.");
                    out.println();
                } else if (!"пока".equals(ask)) {
                    out.println("Ок!");
                    out.println();
                }
            } while (!"пока".equals(ask));
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        try (Socket socket = new ServerSocket(8788).accept()) {
            new Server(socket).start();
        }
    }
}
