package com.company;

import java.util.Random;
import java.util.Scanner;

public class Vt {
    static Scanner sc;
    static Random random;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        random = new Random();
        game();
    }
    public static void game() {
        int n = random.nextInt(9);
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите загаданное число");
            int number = sc.nextInt();
            if (number == n) {
                System.out.printf("Вы угадали! загаданное число %d ", n);
                break;
            } else if (number < n) {
                System.out.println("Вы не угадали!Ваше число меньше загаданного");
            } else if (number > n) {
                System.out.println("Вы не угадали!Ваше число больше загаданного");
            }
        }
        rerun();
    }

    static public void rerun() {
        System.out.println("\nИгра окончена. Повторить игру еще раз? 1 – да / 0 – нет");
        int number = sc.nextInt();
        if (number == 1) {
            game();
        }
    }
}
