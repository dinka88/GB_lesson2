package com.company;

import java.util.Random;
import java.util.Scanner;

public class Lesson4 {
    static final int SIZE = 8;
    static final int DOTS_TO_WIN = 4;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {

        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();

            if (checkWin(DOT_X)) {
                System.out.println("Вы выйграли!");
                break;
            }

            if (isFull()) {
                System.out.println("Конец");
                break;
            }

            aiTurn();
            printMap();

            if (checkWin(DOT_O)) {
                System.out.println("Вы проиграли!");
                break;
            }

            if (isFull()) {
                System.out.println("Конец!");
                break;
            }
        }
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x, y;

        do {
            System.out.println("Введите координаты X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    // Задание 4
    public static void aiTurn() {
        if (aiTurn3() == false) {
            if (aiTurn1() == false) {
                aiTurn2();
            }
        }
    }

    // Пытается понять, где игрок продолжит ставить крестики и блокирует ее
    public static boolean aiTurn1() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < DOTS_TO_WIN; k++) {
                    if (i + k < SIZE && map[i][j] != DOT_O && map[i + k][j] == DOT_X) {
                        map[i][j] = DOT_O;
                        return true;
                    }
                }
                for (int k = 0; k < DOTS_TO_WIN; k++) {
                    if (j + k < SIZE && map[i][j] != DOT_O && map[i][j + k] == DOT_X) {
                        map[i][j] = DOT_O;
                        return true;
                    }
                }
                for (int k = 0; k < DOTS_TO_WIN; k++) {
                    if (i + k < SIZE && j + k < SIZE && map[i][j] != DOT_O && map[i + k][j + k] == DOT_X) {
                        map[i][j] = DOT_O;
                        return true;
                    }
                }
                for (int k = 0; k < DOTS_TO_WIN; k++) {
                    if (i - k >= 0 && j + k < SIZE && map[i][j] != DOT_O && map[i - k][j + k] == DOT_X) {
                        map[i][j] = DOT_O;
                        return true;
                    }
                }
            }

        }
        return false;
    }

    // рандомно ставит 0
    public static void aiTurn2() {
        int x, y;

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
    }

    // Ищет есть ли победная комбинация со следующего хода игрока и прерывает ее
    public static boolean aiTurn3() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X)) {
                        map[i][j] = DOT_O;
                        return true;
                    }
                    map[i][j] = DOT_EMPTY;

                }
            }
        }
        return false;
    }

    //
    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    // Задание 2 и 3
    public static boolean checkWin(char c) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int winv = 0;
                int winh = 0;
                int wind = 0;
                int wind2 = 0;

                for (int k = 0; k < DOTS_TO_WIN; k++) {
                    if (i + k < SIZE && map[i + k][j] == c) {
                        winv++;
                    }
                }
                if (winv == DOTS_TO_WIN) {
                    return true;
                }
                for (int k = 0; k < DOTS_TO_WIN; k++) {
                    if (j + k < SIZE && map[i][j + k] == c) {
                        winh++;
                    }
                }
                if (winh == DOTS_TO_WIN) {
                    return true;
                }
                for (int k = 0; k < DOTS_TO_WIN; k++) {
                    if (i + k < SIZE && j + k < SIZE && map[i + k][j + k] == c) {
                        wind++;
                    }
                }
                if (wind == DOTS_TO_WIN) {
                    return true;
                }
                for (int k = 0; k < DOTS_TO_WIN; k++) {
                    if (i - k >= 0 && j + k < SIZE && map[i - k][j + k] == c) {
                        wind2++;
                    }
                }
                if (wind2 == DOTS_TO_WIN) {
                    return true;
                }
            }

        }
        return false;
    }

}