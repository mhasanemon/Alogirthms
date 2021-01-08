package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {
        int N,E;
        N = input.nextInt();
        E = input.nextInt();

        for(int i=0;i<N+1;i++)
            arrayLists.add(new ArrayList<Integer>());

        for(int i=0;i<E;i++){
            int a,b;
            a = input.nextInt();
            b = input.nextInt();

            arrayLists.get(a).add(b);
            arrayLists.get(b).add(a);
        }

       /* for(int i=0;i<arrayLists.size();i++){
            System.out.println(arrayLists.get(i).size());
        }*/


        if(is_Complete(N)==true){
            System.out.println("The graph is complete");
        }
        else
            System.out.println("The graph is not complete");
    }

    static boolean is_Complete(int n){
        for(int i=1;i<arrayLists.size();i++){
            if(arrayLists.get(i).size()!= n-1)
            {
                return false;
            }

        }
        return true;
    }

}


///////////********* THIS IS A SIMPLE TRICK *********** /////////////////
/* package whatever; // don't place package name! */

import java.util.*;
        import java.lang.*;
        import java.io.*;
        import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner input = new Scanner (System.in);

        int n,e;
        System.out.println("Enter the num of Node and Edge:");
        n = input.nextInt();
        e = input.nextInt();

        if(e==n*(n-1)/2){
            System.out.println("This is a complete graph");
        }
        else
            System.out.println("This is not a complete graph");
    }
}



