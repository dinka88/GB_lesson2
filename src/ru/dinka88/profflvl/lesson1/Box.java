package ru.dinka88.profflvl.lesson1;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();

    public int getWeight() {
        int wt = 0;
        for (int i = 0; i < fruits.size(); i++) {
            T a = fruits.get(i);
            wt = wt + a.wt;
        }
        return wt;
    }

    @Override
    public String toString() {
        return "Box{" +
                "box=" + fruits +
                '}';
    }

    public void info() {
        System.out.println(fruits.toString());
    }

    public boolean compare(Box <?> o) {
        return getWeight() == o.getWeight();
    }

    public void newbox(Box<T> a) {
        List<T> newFruits = a.fruits;
        newFruits.addAll(0, this.fruits);
        fruits.clear();
    }

    public void add(T a) {
        fruits.add(a);
    }

    public void infoWt() {
        System.out.println("Вес коробки " + getWeight() + " гр ");
    }
}

