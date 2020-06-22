package ru.dinka88.advlvl.lesson2;

public class Main {
    public static void main(String[] args) {
        String[][] arr1 = {
                {"5", "10", "2", "7"},
                {"6", "1", "22", "0"},
                {"2", "3", "5", "14"},
                {"8", "!", "5", "9"},
        };
        ArrSumm arr = new ArrSumm(arr1);
        try {
            int sum = arr.sum();
            System.out.println(sum);
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }

    }

}
