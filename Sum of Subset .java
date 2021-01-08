package com.company;

import java.util.*;

class Main {

    static boolean IsSubset(int array[],int sum,int n){
        boolean set[][] = new boolean[n+1][sum+1];

        for(int i=1;i<=sum;i++){
            set[0][1] = false;
        }
        for(int i=0;i<=n;i++){
            set[i][0] = true;
        }

        for(int i=1;i<=n;i++)
            for(int j =1;j<=sum;j++){
                set[i][j] = set[i-1][j];

                if(j>=array[i-1])
                    set[i][j] = set[i][j] || set[i-1][j - array[i-1]];
            }
        /*********** TO PRINT THE TRUE FALSE TABLE******//*
        for(int i = 0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                System.out.print(set[i][j]+" ");
            }
            System.out.println();
        }*/


        return set[n][sum];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int n=input.nextInt();
        System.out.println("Enter the values:");

        int array[] = new int[n];

        for(int i=0;i<n;i++){
            array[i] = input.nextInt();
        }
        System.out.println("Enter the sum:");
        int sum = input.nextInt();

        if(IsSubset(array,sum,n)){
            System.out.println("Found a subset with given sum");
        }
        else
            System.out.printf("No subset found");
    }
}