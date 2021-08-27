package ru.gb.lesson1;

public class Cat extends Animal{

    public static int countC = 0;

    public Cat(String type, String name, String color){
        super(type, name, color);
        ++countC;


    }

    @Override
    public void swim(int meters, int maxSwimDist) {
        System.out.println("Cat can't swim.");
    }

    public void countCat(){
        System.out.println("Cats: " + countC);
    }
}
