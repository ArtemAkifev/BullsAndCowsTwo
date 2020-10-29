package com.bullsAndCows.print;

public class Print {

    public void print (int [] array) {
        for (Integer b : array) {
            System.out.print(b);
        }
        System.out.println();
    }

    public void print (char[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public void printResult (int getCows, int getBulls, int getScore){
        System.out.println("crow " + getCows);
        System.out.println("bulls " + getBulls);
        System.out.println("score " + getScore);
    }

}

