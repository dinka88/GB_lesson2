package ru.dinka88.profflvl.lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Box <Apple> ap= new Box<>();
//        ap.add(new Apple(2));
//        ap.add(new Apple(4));
//        ap.add(new Apple(5));
//        Box <Apple> ap2= new Box<>();
//        ap.add(new Apple(5));
//        ap.add(new Apple(7));
//        ap.add(new Apple(2));
//        Box <Orange> or= new Box<>();
//        or.add(new Orange(6));
//        or.add(new Orange(3));
//        or.add(new Orange(4));
//        or.add(new Orange(7));
//        System.out.println(ap.compare(or));
//        ap.infoWt();
//        or.infoWt();
//        ap.newbox(ap2);
//        ap.info();
//        ap2.info();


        Integer [] a= {2,3,6,7,10,13};
        System.out.println(Arrays.toString(arrElemCopy(a,2,4)));
        String [] b= {"кот","пес","утка","жаба","птица"};
        System.out.println(Arrays.toString(arrElemCopy(b,1,3)));


    }

    // Задание 1
    public static <T> T[] arrElemCopy(T[] arr, int a, int b) {
        T copyA = arr[a];
        arr[a] = arr[b];
        arr[b] = copyA;

        return arr;
    }

    // Задание 2
    public static <T> List<T> array(T[] arr) {
        List<T> newList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            newList.add(arr[i]);
        }
        return newList;
    }
}
