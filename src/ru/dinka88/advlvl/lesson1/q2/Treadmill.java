package ru.dinka88.advlvl.lesson1.q2;

public class Treadmill implements Passable {
    private int dist;

    public Treadmill(int dist) {
        this.dist = dist;
    }

    public  void pass (Participant p){
        p.run(dist);
    }
}
