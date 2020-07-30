package ru.dinka88.profflvl.lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    static void initBarrier(){
        start = new CyclicBarrier(CARS_COUNT);
        startLatch = new CountDownLatch(CARS_COUNT);
        finishLatch = new CountDownLatch(CARS_COUNT);
    }

    public static CyclicBarrier start;
    public static CountDownLatch startLatch;
    public static CountDownLatch finishLatch;

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.start= new CyclicBarrier(CARS_COUNT);
    }


    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            start.await();
            startLatch.countDown();
            System.out.println("Старт!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        finishLatch.countDown();
    }
}
