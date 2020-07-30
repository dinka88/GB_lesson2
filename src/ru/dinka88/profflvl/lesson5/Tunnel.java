package ru.dinka88.profflvl.lesson5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    Semaphore sm= null;
    public Tunnel(int maxCars) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.sm= new Semaphore(maxCars/2);

    }
    @Override
    public void go(Car c) {
        try {
            try {
                sm.acquire();
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                sm.release();
                System.out.println(c.getName() + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
