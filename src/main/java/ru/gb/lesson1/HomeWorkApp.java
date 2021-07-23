package ru.gb.lesson1;

public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println("-----2-----");
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
        System.out.println("-----3-----");
        checkSumSign(25, -98);
        System.out.println("-----4-----");
        printColor(105);
        System.out.println("-----5-----");
        compareNumbers(25, 35);
    }

    public static void checkSumSign(int a, int b){
        int result = a + b;
        if (result >= 0){
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor(int value){
        if (value <= 0){
            System.out.println("Красный");
        }
        if (value > 0 && value <= 100){
            System.out.println("Желтый");
        }
        if (value > 100){
            System.out.println("Зеленый");
        }

    }

    public static void compareNumbers(int a, int b){
        if(a >= b){
            System.out.println("a >= b");
        }
        if(a < b){
            System.out.println("a < b");
        }

    }
}
