package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Задание 1.
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));

        // Задание2
        int[] emptyArray = new int[8];
        for (int i = 0; i < emptyArray.length; i++) {
            emptyArray[i] = i * 3;
        }
        System.out.println(Arrays.toString(emptyArray));

        // Задание 3
        int[] newArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(newArray));
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] < 6) {
                newArray[i]*= 2;
            }
        }
        System.out.println(Arrays.toString(newArray));

        //Задание 4
        int[][] square = new int[5][5];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                if (i == j) {
                    square[i][j] = 1;
                }
                if (i + j + 1 == square.length) {
                    square[i][j] = 1;
                }
            }
            System.out.println(Arrays.toString(square[i]));
        }
        System.out.println(Arrays.toString(square));

        // Задание 5
        int[] maxMinArr = {5, 6, 41, 52, 31, 20, 14};
        System.out.println(Arrays.toString(maxMinArr));
        int max = maxMinArr[0];
        int min = maxMinArr[0];
        for (int i = 1; i < maxMinArr.length; i++) {
            if (maxMinArr[i] > max) {
                max = maxMinArr[i];
            } else if (maxMinArr[i] < min) {
                min = maxMinArr[i];
            }
        }
        System.out.println("Максимальный элемент " + max + ", а минимальный " + min);


        int[] arr1 = {1, 1, 1, 2, 1};
        System.out.println(check(arr1));

    }

    //Задание6
    public static boolean check(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            int sum2 = 0;
            for (int j = 0; j < i; j++) {
                sum = sum + arr[j];
            }
            for (int k = i; k < arr.length; k++) {
                sum2 = sum2 + arr[k];
            }
            if (sum == sum2) {
                return true;
            }
            System.out.println(" Левая " + sum + " Права " + sum2);
        }
        return false;
    }
}
