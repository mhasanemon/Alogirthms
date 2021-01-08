package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    static float knapsack(int number,float weight[],float profit[],float capacity){
        float x[] = new float[20];
        float totalprofit = 0;
        int i;
        for( i=0;i<number;i++){
            if(weight[i]>capacity){
                break;
            }
            else
            {
                x[i] = 1;
                totalprofit = totalprofit + profit[i];
                capacity-=weight[i];
            }
        }
        if(i<number)
            x[i] = capacity/weight[i];

        totalprofit+=(x[i]*profit[i]);
        return totalprofit;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float weight[] = new float[20];
        float profit[] = new float[20];
        float ratio[] = new float[20];

        System.out.printf("Enter the number of elements:\n");
        int num = input.nextInt();

        System.out.println("Enter weights and profits of each element:");
        for(int i=0;i<num;i++)
        {
            weight[i] = input.nextFloat();
            profit[i] = input.nextFloat();
        }
        System.out.println("Enter the capacityacity of knapsack:");
        float capacity = input.nextFloat();

        for (int i = 0; i < num; i++) {
            ratio[i] = profit[i] / weight[i];
        }
        float temp;

        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                if (ratio[i] < ratio[j]) {
                    temp = ratio[j];
                    ratio[j] = ratio[i];
                    ratio[i] = temp;

                    temp = weight[j];
                    weight[j] = weight[i];
                    weight[i] = temp;

                    temp = profit[j];
                    profit[j] = profit[i];
                    profit[i] = temp;
                }
            }
        }
        System.out.println(knapsack(num,weight,profit,capacity));

    }
}