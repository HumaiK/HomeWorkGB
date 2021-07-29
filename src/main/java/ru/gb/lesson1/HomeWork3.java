package ru.gb.lesson1;

import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){

        System.out.println("-----* 1 *-----");
        System.out.print("Enter number of elements in array: ");
        int inputUserInt = scanner.nextInt();
        int [] zeroOneArr = randomNumberArr(inputUserInt);
        printArr(zeroOneArr);
        int[] newInverted = changeArrEl(zeroOneArr);
        System.out.print("Inverted array: ");
        printArr(newInverted);
        System.out.println("-----* 2 *-----");
        int [] hundArr =  hundredArr(100);
        printArr(hundArr);
        System.out.println("-----* 3 *-----");
        int[] replaced = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArr(replaced);
        System.out.print("Replaced array is: ");
        replacedArr(replaced);
        printArr(replaced);
        System.out.println("-----* 4 *-----");
        squareArray(6,6);
        System.out.println("-----* 5 *-----");
        oneDimensionalArr(5,0);
        printArr(oneDimensionalArr(5,7));
        System.out.println("-----* 6 *-----");
        printArr(replaced);
        maxElem(replaced);
        minElem(replaced);

    }
    public static int[] randomNumberArr(int elems){
        int[] numb = new int[elems];
        for (int i = 0; i < elems; i++){
            numb [i] = random.nextInt(2);
        }
        return numb;
    }

    public static void printArr(int[] ourArray){
        for (int i = 0; i < ourArray.length; i++){
            System.out.print(ourArray[i] + " ");
        }
        System.out.println();
    }

    public static int[] changeArrEl(int existArr[]) {
        for (int i = 0; i < existArr.length; i++) {
            existArr[i] = existArr[i] == 0 ? 1 : 0;
        }
        return existArr;
    }

    public static int[] hundredArr(int lengthArr){
        int[] arr = new int[lengthArr];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }
        return arr;

    }

    public static int[] replacedArr(int arr[]){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 6){
                arr[i] = arr[i] * 2;
            }
                   }
        return arr;
    }

    public static void squareArray(int valueI, int valueJ) {
        int [][] array = new int[valueI][valueJ];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    array[i][j] = 1;
                } else
                    array[i][j] = random.nextInt(8);
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" " + array[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[] oneDimensionalArr (int len, int initialValue){
        int[] arr = new int[len];
        for (int i = 0; i < len; i++){
            arr [i] = initialValue;
        }
        return arr;

    }

    public static void maxElem (int [] arr){
        int maxI = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > maxI) {
                maxI = arr[i];
            }
        }
        System.out.println("Max element is: " + maxI);
    }

    public static void minElem (int [] arr){
        int minI = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < minI) {
                minI = arr[i];
            }
        }
        System.out.println("Min element is: " + minI);

    }

}
