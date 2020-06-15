package ru.dinka88.lesson7;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public boolean eatenFood(int amount) {
        if (food - amount < 0) {
            System.out.println("Еды не достаточно");
            return false;
        } else {
            food -= amount;
            return true;
//
        }
    }

    public void info() {
        System.out.println("В тарелке " + food + " еды ");
    }

    public void infoBalance() {
        System.out.println("В тарелке осталось " + food + " еды ");
    }

    public void addFood() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Сколько добавить еды в миску?");
        int newFood= sc.nextInt();
        food += newFood;
        System.out.println("В миске стало "+ food+ " еды ");
        sc.close();
    }
}
