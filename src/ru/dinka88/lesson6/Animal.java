package ru.dinka88.lesson6;

public class Animal {
    String name;
    static int animalNumber;

    public Animal(String name) {
        this.name = name;
        this.animalNumber= animalNumber+1;
    }

    public void info() {
        System.out.println("Животное зовут " + name);
    }

    public void run(int n) {
        System.out.println("Животное " + name + " пробежал " + n + "м");

    }

    public void swim(int m) {
        System.out.println("Животное " + name + " проплыло " + m);
    }
    public static void quantity (){
        System.out.println("Колличество животных "+ animalNumber);
    }
}