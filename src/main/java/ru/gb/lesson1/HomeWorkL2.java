package ru.gb.lesson1;

import org.omg.CORBA.WStringSeqHelper;

public class HomeWorkL2 {
    public static void main(String[] args){
        System.out.println("-----1-----");
        System.out.println(sum10a20(25, 5));
        System.out.println("-----2-----");
        posNeg(6);
        System.out.println("-----3-----");
        System.out.println(negative(5));
        System.out.println("-----4-----");
        printer("some text", 5);

    }
    public static boolean sum10a20(int a, int b){
        if (a + b > 10 && a + b <= 20){
            return true;
        }
            return false;
    }
    public static void posNeg(int a){
        if (a >= 0){
            System.out.println("Integer is positive");
        }else {
            System.out.println("Integer is negative");
        }
    }
    public static boolean negative(int a){
        if (a < 0){
            return true;
        }
        return false;
    }
    public static void printer (String text, int times){
        for (int i = 0; i < times; i++){
            System.out.println(text);
        }

    }
}
