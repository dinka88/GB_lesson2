package ru.dinka88.advlvl.lesson1.q2;

public class Wall implements Passable {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public void pass (Participant p){
        p.jump(height);
    }
}
