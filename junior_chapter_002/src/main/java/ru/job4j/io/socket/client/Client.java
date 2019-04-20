package ru.job4j.io.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;

import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void connectToServer() throws IOException {
        try (PrintWriter outToServer = new PrintWriter(this.socket.getOutputStream(), true);
             BufferedReader inFromServer = new BufferedReader(new InputStreamReader(this.socket.getInputStream()))) {
            Scanner console = new Scanner(System.in);
            String str;
            do {
                System.out.println("Напишите что то");
                str = console.nextLine();
                outToServer.println(str);
                if (!"пока".equals(str)) {
                    do {
                        str = inFromServer.readLine();
                        if (!str.isEmpty()) {
                            System.out.println(str);
                        }
                    } while (!str.isEmpty());
                }
            } while (!"пока".equals(str));
        } catch (IOException e) {
            e.getStackTrace();
        }
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(InetAddress.getLocalHost(), 8788)) {
            new Client(socket).connectToServer();
        }
    }
}
