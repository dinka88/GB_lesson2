package ru.dinka88.profflvl.lesson1;

public class Apple extends Fruit {
    String name= "яблоко";
    public Apple(int wt) {
        super(wt);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", wt=" + wt +
                '}';
    }
}
