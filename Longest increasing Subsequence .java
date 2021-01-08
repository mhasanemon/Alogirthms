package com.company;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int maxLength = 0;
        int end = 0 ;

        System.out.println("Enter the size of the array:");
        int n=input.nextInt();
        System.out.println("Enter the values:");

        int array[] = new int[n];
        int length[] = new int[n];
        int prev[] = new int[n];

        for(int i=0;i<n;i++){
            array[i] = input.nextInt();
            length[i] = 1;
        }

        prev[0] = -1;

        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(array[j]<array[i] && length[j]+1>length[i]){
                    length[i]= length[j]+1;
                    prev[i] = j;
                }
            }
            if(maxLength<length[i]){
                maxLength = length[i];
                end = i;
            }
        }

        System.out.println("The length of the longest increasing Subsequence is: "+maxLength);

        System.out.println("The sequence is :");
        int array2[] = new int[maxLength];
        int var = maxLength-1;

        while (end != -1 && var>=0){
            array2[var] = array[end];
            end = prev[end];
            var--;
        }

        for(int i=0;i<array2.length;i++)
            System.out.printf("%d ",array2[i]);
    }
}