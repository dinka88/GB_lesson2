package ru.dinka88.advlvl.lesson1.q1;

public class Human implements RunJump {
    String name;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(" " + name + " ran... ");
    }

    @Override
    public void jump() {
        System.out.println(" " + name + " jumped...");
    }
}
