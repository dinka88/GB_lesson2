package ru.dinka88.advlvl.lesson1.q2;

import ru.dinka88.advlvl.lesson1.q2.Participant;

public class People implements Participant {
    public String name;
    private int maxRunDistance;
    private int maxJumpHeight;
    private boolean isOnDistance;

    public People(String name,int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance =maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.isOnDistance= true;
    }

    @Override
    public void run(int dist) {
        if(dist<= maxRunDistance && isOnDistance){
            System.out.println( name + " пробежал " + dist + " м ");
        }else {
            System.out.println( name + " не смог пробежать " + dist+ " м ");
            isOnDistance = false;
        }

    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight && isOnDistance) {
            System.out.println(name + " прыгнул на " + height + " м ");
        } else {
            System.out.println(name + " не смог прыгнуть на " + height + " м ");
            isOnDistance = false;
        }
    }

    @Override
    public boolean onDistance() {
        return isOnDistance;
    }
}


