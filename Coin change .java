package com.company;

import java.util.*;

class Main {

    static int CoinChange(int array[], int n, int sum) {
        int table[][] = new int[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            table[i][0] = 0;
        }
        /*for(int i=0;i<sum+1;i++){
            table[0][i] = 0;
        }
*/
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (i == 1) {
                    if (array[i - 1] > j)
                        table[i][j] = table[i - 1][j];
                    else
                        table[i][j] = table[i][j - array[i - 1]] + 1;

                }
                else
                {
                    if (array[i - 1] > j)
                        table[i][j] = table[i - 1][j];
                    else {
                        if (table[i - 1][j] > table[i][j - array[i - 1]] + 1) {
                            table[i][j] = table[i][j - array[i - 1]] + 1;
                        }
                        else
                            table[i][j] = table[i - 1][j];
                    }

                }
            }
        }

            /*for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < sum + 1; j++) {
                    System.out.print(table[i][j] + " ");
                }
                System.out.println();
            }*/
            return table[n][sum];
        }

        public static void main (String[]args){
            Scanner input = new Scanner(System.in);

            System.out.println("Enter the number of coin:");
            int n = input.nextInt();
            System.out.println("Enter the coins:");

            int array[] = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = input.nextInt();
            }
            System.out.println("Enter the sum:");
            int sum = input.nextInt();
            int result = CoinChange(array, n, sum);
            if (result > 0)
                System.out.printf("The number of coin required is %d", result);
            else
                System.out.printf("Can't change the coin");
        }
    }