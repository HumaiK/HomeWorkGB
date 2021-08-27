package ru.gb.lesson1;

public class Dog extends Animal{

    public static int countD = 0;

    public Dog(String type, String name, String color){
        super(type, name, color);
        ++countD;
    }

    public void countCDog(){
        System.out.println("Dogs: " + countD);
    }
}
