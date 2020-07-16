package ru.dinka88.advlvl.lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    static final int PORT = 24568;
    static ServerSocket server;
    static Socket socket;

    public static void main(String[] args) throws IOException {
        server = new ServerSocket(PORT);
        System.out.println(" Сервер запущен");
        socket = server.accept();
        System.out.println(" Клиент подключился");


        Thread thread = new Thread(() -> {
            try {
                Scanner sc = new Scanner(socket.getInputStream());

                while (true) {
                    String text = sc.nextLine();
                    System.out.println(text);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        Thread thread2 = new Thread(() -> {

            try {
                Scanner sc = new Scanner(System.in);
                PrintWriter answer = new PrintWriter(socket.getOutputStream());
                while (true) {
                    String text = sc.nextLine();
                    answer.println(text);
                    answer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread2.start();

    }
}



