package ru.gb.lesson1;

public class Employee {   // 1. класс с полями

    private String name;
    private String position;
    private String email;
    private int phoneNumber;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, int phoneNumber, int salary, int age) {  //2. конструктор класса
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public int getAge(){
        return age;
    }



    void info(){    // 3. метод, который выводит информацию об объекте
        System.out.println();
        System.out.println("Information about employee \nName: " + name + "\nPosition: " + position + "\nEmail: " + email + "\nPhone: " + phoneNumber + "\nSalary: " + salary + "\nAge: " + age);
    }
}
