package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;
class data implements Comparable<data>{
    int v,w;

    @Override
    public int compareTo(data o) {
        return Integer.compare(w,o.w);
    }
}

class Main{
    static Scanner input = new Scanner(System.in);

    static int visited[] = new int[100];
    static Vector <Vector<Integer>> edge = new Vector<>();
    static Vector <Vector<Integer>> cost = new Vector<>();

    static int prims(int source,int n){
        PriorityQueue<data> pq = new PriorityQueue<data>();

        int u,v,p=0;
        int sum = 0;

        for(int i=0;i<n-1;i++){
            u = source;
            visited[source] = 1;

            for(int j=0;j<edge.get(u).size();j++){
                v = edge.get(u).get(j);
                if(visited[v]==0){
                    data D = new data();
                    D.w = cost.get(u).get(j) ;
                    D.v = v;
                    pq.add(D);
                }
            }

            while (visited[source]==1){
                data T = pq.peek();
                pq.remove();

                source = T.v;
                p = T.w;
            }
            System.out.printf("%d ", p);
            sum= sum + p;
        }
        return sum;

    }
    public static void main(String[] args) {
        int Node,Edge,n1,n2,w;

        System.out.printf("Enter the No of Node and Edge:\n");
        Node = input.nextInt();
        Edge = input.nextInt();

        for(int k=0;k<Node+1;k++){
            edge.add(new Vector<>());
            cost.add((new Vector<>()));
        }

        for(int i=0;i<Edge;i++){
            System.out.println("Enter the nodes and weight");
            n1 = input.nextInt();
            n2 = input.nextInt();
            w = input.nextInt();

            edge.get(n1).add(n2);
            edge.get(n2).add(n1);

            cost.get(n1).add(w);
            cost.get(n2).add(w);

        }
        System.out.println("The path is:");
        ////////////******** Start with 1 as source
        System.out.println("\n\nThe total cost of the path of minimim spanning tree is:"+prims(1,Node));
    }
}

