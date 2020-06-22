package ru.dinka88.advlvl.lesson2;

public class MyArrayDataException extends Exception {
    private int i;
    private int j;

    public MyArrayDataException(int i, int j) {
        super("Ошибка в элементе с индексом " + i + " " + j);
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
