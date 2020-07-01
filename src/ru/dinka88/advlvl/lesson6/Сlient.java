package ru.dinka88.advlvl.lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Сlient {
    static final int PORT = 24568;
    static final String IP_ADDRESS = "localhost";

    public static void main(String[] args) throws IOException {
        Socket client = new Socket(IP_ADDRESS, PORT);

        Thread thread = new Thread(() -> {
            try {
                Scanner sc = new Scanner(System.in);
                PrintWriter answer = new PrintWriter(client.getOutputStream());
                while (true) {
                    String text = sc.nextLine();
                    answer.println(text);
                    answer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Thread thread2 = new Thread(() -> {
            try {
                Scanner sc = new Scanner(client.getInputStream());
                while (true) {
                    String text = sc.nextLine();
                    System.out.println(text);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread2.start();
    }

}
