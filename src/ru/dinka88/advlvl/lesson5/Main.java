package ru.dinka88.advlvl.lesson5;

public class Main {
    static final int size = 10_000_000;
    static final int h = size / 2;


    public static void main(String[] args) {
        array1();
        array2();
    }

    public static void array1() {
        float[] arr = new float[size];
        Arr compute = new Arr(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long start = System.currentTimeMillis();
        compute.run();
        System.out.println(System.currentTimeMillis() - start);

    }

    public static void array2() {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long start = System.currentTimeMillis();
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        Thread t1 = new Thread(new Arr(arr1));
        Thread t2 = new Thread(new Arr(arr2));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.println(System.currentTimeMillis() - start);


    }
}
