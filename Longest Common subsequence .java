package com.company;

import java.util.Scanner;

class Main{
    static int LCS(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        int lcsTable[][] = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    lcsTable[i][j]=0;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    lcsTable[i][j] = lcsTable[i-1][j-1]+1;
                }
                else
                    lcsTable[i][j] = Math.max(lcsTable[i-1][j],lcsTable[i][j-1]);
            }
        }
        return lcsTable[m][n];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String s1 ,s2;
        System.out.println("Enter the first sequence :");
        s1 = input.next();

        System.out.println("Enter the second sequence :");
        s2 = input.next();

        System.out.printf("Length of LCS is %d",LCS(s1,s2));
    }
}