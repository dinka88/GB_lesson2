package ru.dinka88.advlvl.lesson1.q1;

public class Cat implements RunJump {
    String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(" Cat " + name + " ran...");
    }

    @Override
    public void jump() {
        System.out.println(" Cat " + name + " jumped...");

    }
}
