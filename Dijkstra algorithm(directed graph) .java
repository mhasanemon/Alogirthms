package com.company;

import java.util.*;


class Main{
    static Scanner input = new Scanner(System.in);
    static Vector<Vector<Integer>> vector = new Vector<>();
    static int cost[][] = new int[100][100];

    static int distance[] = new int[100];


    static void Dijkstra(int source){
        PriorityQueue<Integer> Q = new PriorityQueue<>();
        Q.add(source);
        System.out.println(Q.peek());
        distance[source] = 0;

        while (!Q.isEmpty()){
            int u = Q.peek();
            System.out.println(Q.remove());

            for(int i=0;i<vector.get(u).size();i++){
                int v = vector.get(u).get(i);
                if(distance[u]+cost[u][v]<distance[v]){
                    distance[v] = distance[u]+cost[u][v];
                    Q.add(v);
                }
            }
        }

    }



    public static void main(String[] args) {
        int Node,Edge,n1,n2,w;

        System.out.printf("Enter the No of Node and Edge:\n");
        Node = input.nextInt();
        Edge = input.nextInt();

        for(int i=0;i<Node+1;i++){
            vector.add(new Vector<>());
            distance[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<Edge;i++){
            System.out.println("Enter the nodes and weight");
            n1 = input.nextInt();
            n2 = input.nextInt();
            w = input.nextInt();

            vector.get(n1).add(n2);
            //vector.get(n2).add(n1);
            cost[n1][n2] = w;
            //cost[n2][n1] = w;
        }
        System.out.println("Enter the soure : ");
        int source = input.nextInt();
        Dijkstra(source);
        ////////////******** Start with 0 as source
       for(int i=0;i<Node;i++){
           System.out.println("Distance from source to "+i+" is "+distance[i]);
       }
    }
}

