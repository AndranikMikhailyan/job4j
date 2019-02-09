package ru.job4j.inpututput.socket.client;

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
        PrintWriter outToServer = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        Scanner console = new Scanner(System.in);
        String str;
        do {
            System.out.println("Напишите что то");
            outToServer.println((str = console.nextLine()));
            if (!"пока".equals(str)) {
                while (!(str = inFromServer.readLine()).isEmpty()) {
                    System.out.println(str);
                }
            }
        } while (!"пока".equals(str));
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(InetAddress.getLocalHost(), 8788)) {
            new Client(socket).connectToServer();
        }
    }
}
