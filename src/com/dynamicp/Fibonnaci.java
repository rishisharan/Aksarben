package com.dynamicp;

public class Fibonnaci {
    public static void main(String[] args) {
        int maxNumber = 8;
        System.out.print("Fibonacci Series of "+maxNumber+" numbers: ");
        System.out.print(fibonacciRecursion(maxNumber) +" ");

    }

    public static int fibonacciRecursion(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        return fibonacciRecursion(n-2) + fibonacciRecursion(n-1);
    }


}
