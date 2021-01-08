package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main{
    static Scanner input = new Scanner(System.in);
    static ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {
        int N,E;

        System.out.println("Enter the number of nodes and edges:");

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

        int source;
        System.out.println("Enter the source:");
        source = input.nextInt();

        int level[] = new int[N];
        int visited[] = new int[N];
        int parent[] = new int[N];
        Integer nuulll = null;
        parent[source] = 0;

        Queue<Integer> queue = new LinkedList<>();

        visited[source] = 1;

        queue.add(source);

        while (!queue.isEmpty()){
            int u = queue.peek();

            for (int i=0;i<arrayLists.get(u).size();i++){
                int v = arrayLists.get(u).get(i);
                if(visited[v]==0){
                    level[v] = level[u]+1;
                    visited[v]=1;
                    parent[v]=u;
                    queue.add(v);
                }
            }
            queue.remove();
        }
        for(int i=source;i<=N;i++){
            System.out.println(source+" to distance "+i+" is "+ level[i]+" and parent is "+parent[i]);
        }

    }
}