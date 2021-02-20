package com.recursion.backtracking;


import top100.medium.GenerateParenthesis;

/*
    Given a positive integer number N. The task is to generate all the binary strings of N bits. These binary strings should be in ascending order.
 */
public class GeneratAllStrings {
    public static void main(String[] args) {
        int n = 2;
        int arr[] = new int[n];
        GeneratAllStrings s = new GeneratAllStrings();
        generateBinaryString(arr, n, 0);
    }

    static void generateBinaryString(int[] arr, int n, int i){
        if( i == n){
            printTheArray(arr, n);
            return;
        }

        arr[i] = 0;
        generateBinaryString(arr, n, i + 1);
        arr[i] = 1;
        generateBinaryString(arr, n, i + 1);
    }

    static void printTheArray( int[] arr, int n){
        for ( int i = 0;i< n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}
