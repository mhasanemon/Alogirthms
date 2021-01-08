package com.company;

import java.util.Scanner;

class Main{
    static int knapSack(int weight[],int value[],int item,int w){
        int benefit[][] = new int[item+1][w+1];

        for(int i=0;i<=item;i++)
            for(int j=0;j<=w;j++){
                if(i==0 || j==0){
                    benefit[i][j] = 0;
                }
                else if(weight[i-1]>j)
                    benefit[i][j] = benefit[i-1][j];
                else
                    benefit[i][j] = Math.max(benefit[i-1][j],value[i-1]+benefit[i-1][j-weight[i-1]]);
            }
        return benefit[item][w];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of item:");
        int item = input.nextInt();

        int value[] = new int[item];
        int weight[] = new int[item];

        for(int i=0;i<item;i++){
            System.out.println("Enter the weigh and value of item: "+(i+1));
            weight[i] = input.nextInt();
            value[i] = input.nextInt();
        }

        System.out.println("Enter the total weight:");
        int w = input.nextInt();

        System.out.println("The maximum benefit is:"+knapSack(weight,value,item,w));
    }
}