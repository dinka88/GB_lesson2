package ru.dinka88.lesson6;

public class Cat extends Animal {
    static int catNumber;
    public Cat(String name) {
        super(name);
        this.catNumber = catNumber +1;
    }

    @Override
    public void swim(int m) {
        System.out.println(name + " не умеет плавать!");
    }

    @Override
    public void run(int n) {
        if (n > 200) {
            System.out.println(name + " не может пробежать " + n + " м ");
        } else {
            System.out.println(name + " пробежал " + n + " м ");
        }
    }
    public static void quantity (){
        System.out.println("Колличество котов "+ catNumber);
    }
}
