package com.company;

import javax.xml.crypto.Data;
import java.util.*;

class data implements Comparable<data>{
    int u,v,w;

    @Override
    public int compareTo(data o) {
        return Integer.compare(w,o.w);
    }
}

class Main{
    static Scanner input = new Scanner(System.in);

    static int parent[] = new int[100];
    static Vector<data> vector = new Vector<>();
    static int find(int r){
        if(parent[r]== r){
            return r;
        }
        else
            return find(parent[r]);

    }

    static int Kruskal(int node){
        int sum=0;
        int count = 0;

        Collections.sort(vector);

        for(int i=1;i<=node;i++){
            parent[i] = i;
        }

        for(int i =0;i<vector.size();i++){
            int u = find(vector.get(i).u);
            int v = find(vector.get(i).v);

            if(u!=v){
                parent[u] = v;
                count++;
                System.out.printf(" %d", vector.get(i).w);
                sum+=vector.get(i).w;
                if(count == (node-1)){
                    break;
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int Node,Edge,n1,n2,w;

        System.out.printf("Enter the No of Node and Edge:\n");
        Node = input.nextInt();
        Edge = input.nextInt();


        for(int i=0;i<Edge;i++){
            System.out.println("Enter the nodes and weight");
            n1 = input.nextInt();
            n2 = input.nextInt();
            w = input.nextInt();

            data D = new data();
            D.w = w;
            D.u = n1;
            D.v = n2;
            vector.add(D);
        }
        System.out.println("The path is:");
        ////////////******** Start with 1 as source
        System.out.println("\n\nThe total cost of the path of minimim spanning tree is:"+Kruskal(Node));
    }
}

