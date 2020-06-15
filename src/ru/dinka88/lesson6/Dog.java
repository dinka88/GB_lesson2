package ru.dinka88.lesson6;

public class Dog extends Animal {
    int max;
    static int dogNumber;


    public Dog(String name,int max) {
        super(name);
        this.max= max;
        this.dogNumber= dogNumber +1;
    }

    @Override
    public void run(int n) {
        if (n > max) {
            System.out.println(name + " не может пробежать " + n + " м ");
        } else {
            System.out.println(name + " пробежал " + n + " м ");
        }
    }

    @Override
    public void swim(int m) {
        if (m > 10) {
            System.out.println(name + " не может проплыть " + m + " м ");
        } else {
            System.out.println(name + " проплыл " + m + " м ");
        }
    }
    public static void quantity (){
        System.out.println("Колличество собак "+ dogNumber);
    }
}
