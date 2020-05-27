package com.company;

public class Lesson5 {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Petr", "Ivanov", "Ivanovach", "manager", "dsd@gmail.com", "89162547859", 50000, 26);
        Employee employee2 = new Employee("Ivan", "Petrov", "Petrovich", "manager", "fhgfh@mail.ru", "5465454", 20000, 54);
        Employee employee3 = new Employee("Sweta", "Petrova", "Ivanovna", "manager", "fhgfds@mail.ru", "545741254", 28000, 41);
        Employee employee4 = new Employee("Artem", "Petrov", "Petrovich", "manager", "48fh@mail.ru", "9685454", 36000, 36);
        Employee employee5 = new Employee("Dmitriy", "Sidorov", "Aleksandrovich", "manager", "5115fh@mail.ru", "5444154", 26000, 48);
        //employee1.info();

        Employee[] emplArr = {employee1, employee2, employee3, employee4, employee5};
        for (int i = 0; i < emplArr.length; i++) {
            if (emplArr[i].age > 40) {
                emplArr[i].info();
            }
        }

    }
}