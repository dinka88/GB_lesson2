package com.company;

public class Employee {
    String firstName;
    String surname;
    String patronymic;
    String position;
    String email;
    String phoneNumber;
    int salary;
    int age;

    public Employee(String firstName, String surname, String patronymic, String position, String email,
                    String phoneNumber, int salary, int age) {
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println(firstName + " " + surname + " " + age + " " + position);
    }

}
