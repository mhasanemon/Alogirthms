package com.company;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main{
    static int coinChange(int array[],int amount){
        int num=0;
        int coin = 0;
        int index = array.length-1;
        //System.out.println(array[index]);
        while (amount>0)
        {
            if(amount>array[index]){
                num = amount/array[index];
                coin+=num;
                amount-=(num*array[index]);
            }
            else
                index--;

        }
        return num;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of coins available:");
        int n = input.nextInt();

        System.out.println("Enter the total amount:");
        int amount = input.nextInt();

        int a[] = new int[n];
        System.out.println("Enter the values of the coin:");
        for(int i=0;i<n;i++){
             a[i]= input.nextInt();
        }
        Arrays.sort(a);

        System.out.println("The number of coins needed:"+coinChange(a,amount));
    }
}