package com.example;

import java.util.Scanner;
import java.lang.Math;

public class lab2 {

    private static int[][] randomFilling(int[][] array){
        final int RANGE = 30;
        final int DISTANCE = 15;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j]= (int) Math.round((Math.random()*RANGE)-DISTANCE);
            }
        }
        return array;
    }
    private static int [][] manualFilling(int[][] array){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("[" + i + "]" + "[" + j + "] ");
                array[i][j] = scanner.nextInt();
            }
        }
        return array;
    }

    private static int [][] printArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        return array;
    }
    private static int findMax(int[][] array){

        int maxValue=array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j]>maxValue){
                    maxValue=array[i][j];
                }
            }
        }
        return maxValue;
    }
    private static int findMin(int[][] array){

        int minValue=array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j]<minValue){
                    minValue=array[i][j];
                }
            }
        }
        return minValue;
    }

    private static double arithmeticAvenger(int[][] array){
        float aveArray=0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                aveArray+=array[i][j];
            }
        }
        aveArray=aveArray/(array.length*array[0].length);

        return aveArray;
    }
    private static double geometricAvenger(int [][] array){
        double aveArray=1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                aveArray*=array[i][j];
            }
        }
        double power = (double) 1/(array.length*array[0].length);
        aveArray=Math.pow(aveArray,power);
        return aveArray;
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What input is needed, manual or random?(1/0): ");
        int example = scanner.nextInt();

        System.out.print("Input length line array: ");
        int line = scanner.nextInt();

        System.out.print("Input length column array: ");
        int column = scanner.nextInt();

        if(line>20 ){
            line = 20;
            System.out.print("Will be 20");
        }

        if(column>20 ){
            column = 20;
            System.out.print("Will be 20");
        }

        int[][] array = new int[line][column];

        switch (example)      {
            case 0:
                array=randomFilling(array);
                break;
            case 1:
                array=manualFilling(array);
                break;
            default:
                System.out.println("Option don`t choose");
        }

        printArray(array);

        System.out.println("Max value: 0"+findMax(array));
        System.out.println("Min value: "+findMin(array));
        System.out.println("Arithmetic avenger value: "+arithmeticAvenger(array));
        System.out.println("Geometric avenger value: "+geometricAvenger(array));

    }
}
