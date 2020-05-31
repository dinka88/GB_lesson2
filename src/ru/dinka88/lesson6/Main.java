package ru.dinka88.lesson6;

public class Main {
    public static void main(String[] args) {
        Cat cat= new Cat("Barsik");
        Cat cat2=new Cat("Murzic");
        cat.info();
        cat.run(300);
        cat.swim(200);
        Dog dog= new Dog("Sharik", 700);
        dog.info();
        dog.run(500);
        dog.swim(200);
        Cat.quantity();
        Dog.quantity();
        Animal.quantity();
    }
}





