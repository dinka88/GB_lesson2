package ru.dinka88.advlvl.lesson1.q1;

public class Robot implements RunJump {
    String name;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(" Robot " + name + " ran... ");
    }

    @Override
    public void jump() {
        System.out.println(" Robot " + name + " jumped...");
    }
}
