package ru.dinka88.profflvl.lesson1;

public class Fruit {
    int wt;

    public Fruit(int wt) {
        this.wt = wt;
    }

    public void info() {
        System.out.println("Вес фрукта " + wt + "гр");
    }
}
