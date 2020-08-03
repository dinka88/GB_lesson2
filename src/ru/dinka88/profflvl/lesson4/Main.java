package ru.dinka88.profflvl.lesson4;

public class Main {
    static volatile String prev = "C";

    public static void main(String[] args) {
        Object mon = new Object();


        Thread a = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (mon) {
                    while (prev != "C") {
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A");
                    prev = "A";
                    mon.notifyAll();

                }
            }
        });
        Thread b = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (mon) {
                    while (prev != "A") {
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("B");
                    prev = "B";
                    mon.notifyAll();
                }
            }
        });
        Thread c = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (mon) {
                    while (prev != "B") {
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("C");
                    prev = "C";
                    mon.notifyAll();
                }
            }
        });


        a.start();
        b.start();
        c.start();


    }
//     Задание 2. Я не стала ничего менять в коде, т.к нет особого смысла. Единственное на что можно было бы заменить это
//     executor cached thread pool. Но и нагрузка и выполнение задачи было бы одиноковой, т.к все равно под каждого свой поток.
//     Остальные реализации не подходят, т.к. мы заранее не можем знать какое колличество клиентов у нас будет.

}
