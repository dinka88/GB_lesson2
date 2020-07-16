package ru.dinka88.profflvl.lesson1;

public class Orange extends Fruit {
    String name="апельсин";

    public Orange(int wt) {
        super(wt);
    }

    @Override
    public String toString() {
        return "Orange{" +
                "name='" + name + '\'' +
                ", wt=" + wt +
                '}';
    }
}
