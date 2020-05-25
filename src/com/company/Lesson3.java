package com.company;


import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    static Scanner sc;
    static Random random;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        random = new Random();
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String randomWords = words[random.nextInt(words.length)];

        game2(randomWords);
        game();
        sc.close();
    }
    //Задание 1

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
        //Задание 2

    static public void game2(String randomWords) {
        System.out.println("Введите загаданное слово");
        String wordsUser = sc.nextLine();
        String answer = new String();
        if (randomWords == wordsUser) {
            System.out.println("Верно!");
        } else {
            for (int i = 0; i < 15; i++) {
                if (i < wordsUser.length() && i < randomWords.length() && randomWords.charAt(i) == wordsUser.charAt(i)) {
                    answer = answer + randomWords.charAt(i);
                } else {
                    answer = answer + '#';
                }
            }
            System.out.println(answer);
        }
        game2(randomWords);
    }
}
