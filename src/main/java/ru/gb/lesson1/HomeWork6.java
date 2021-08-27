package ru.gb.lesson1;

public class HomeWork6 {

    public static void main(String[] args) {

        Cat cat = new Cat("Cat", "Mary", "white");
        Dog dog = new Dog("Dog", "Jack", "black");
        Cat cat1 = new Cat("Cat", "Murzik", "brown");

        System.out.println(cat.getFullInfo());
        cat.run(150, 200);
        cat.swim(100,300);
        System.out.println();
        System.out.println(dog.getFullInfo());
        dog.run(300,500);
        dog.swim(3,10);
        System.out.println();
        System.out.println(cat1.getFullInfo());
        cat1.run(100,500);
        cat1.swim(200,1000);
        cat.countCat();
        dog.countCDog();

    }





}
