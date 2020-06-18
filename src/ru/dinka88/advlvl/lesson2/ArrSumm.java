package ru.dinka88.advlvl.lesson2;

public class ArrSumm {
    String[][] arr;

    public ArrSumm(String[][] arr) {
        this.arr = arr;
    }

    public int sum() throws MyArrayDataException, MyArraySizeException {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != 4 || arr[i].length != 4) {
                throw new MyArraySizeException("Размер массива не верный!");
            }
            for (int j = 0; j < arr[i].length; j++) {
                String cell = arr[i][j];
                try {
                    int anInt = Integer.parseInt(cell);
                    sum += anInt;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
