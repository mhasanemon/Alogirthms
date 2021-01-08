package com.company;

import java.util.Scanner;

class Main{
    static void Rock_climb(int matrix[][],int row,int column){
        int array[][] = new int[row+1][column+2];

        for(int i=0;i<row;i++){
            array[i][0] = Integer.MAX_VALUE;
            array[i][column+1] = Integer.MAX_VALUE;
        }

        for(int i=1;i<column+1;i++)
            array[0][i]=0;

        for(int i=1;i<row+1;i++)
        {
            for(int j=1;j<column+1;j++){
                array[i][j] = matrix[i-1][j-1]+ Math.min(array[i-1][j-1],Math.min(array[i-1][j],array[i-1][j+1]));
            }
        }

        for(int i=1;i<row+1;i++){
            for(int j=1;j<column+1;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter the no of row and column: ");
        int row = input.nextInt();
        int column = input.nextInt();

        System.out.println("Enter the matrix:");
        int matrix[][] = new int[row][column];

        for(int i=0;i<row;i++)
            for(int j=0;j<column;j++){
                matrix[i][j] = input.nextInt();
            }

        Rock_climb(matrix,row,column);

        //******** can't find a way to print the path if you have any edit the doc
    }
}