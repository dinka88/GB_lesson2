package ru.dinka88.lesson7;

public class Cat {
    String name;
    int satiety = 0;
    int catFood;

    public Cat(String name, int catFood) {
        this.name = name;
        this.catFood = catFood;
    }

    public void eat(Plate plate) {
        boolean result= plate.eatenFood(catFood);
        if(result==true) {
            satiety = catFood;
        }

    }

    public void infoSatiety() {

        if (satiety <= 0) {
            System.out.println("Кот " + name + " голодный");
        } else {
            System.out.println("Кот " + name + " сыт!");
        }
    }

}
