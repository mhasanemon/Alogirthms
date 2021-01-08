package com.company;

import java.util.Scanner;

class Main {
    static int Matrix_chain_Multiplication(int array[], int num) {
        int matrix[][] = new int[num][num];
        int k;
        for (int i = 1; i < num; i++) {
            matrix[i][i] = 0;
        }
        for (int j = 2; j < num; j++) {
            for(int i=1;i<num-j+1;i++){
                k = i+j-1;
                matrix[i][k] = Integer.MAX_VALUE;

                for(int m = i;m<=k-1;m++){
                    int q = matrix[i][m]+ matrix[m+1][k]+ array[i-1]*array[m]*array[k];
                    if(q<matrix[i][k])
                        matrix[i][k] = q;
                }
            }
        }
        return matrix[1][num-1];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter the number of element :");
        int num = input.nextInt();
        int array[] = new int[num];

        System.out.printf("Enter the elements:\n");
        for (int i = 0; i < num; i++)
            array[i] = input.nextInt();

        System.out.print( Matrix_chain_Multiplication(array, num));
    }
}