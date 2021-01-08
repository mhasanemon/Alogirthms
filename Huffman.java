package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node{
    int data;
    Node left;
    Node right;
}

class NodeComparator implements Comparator<Node>{
    @Override
    public int compare(Node o1, Node o2) {
        return o1.data-o2.data;
    }
}
class Main{
    static void huffman(PriorityQueue<Node> pq){
        Node x,y;

        for(int i=0;i<5;i++){
            Node z = new Node();
            x = pq.remove();
            z.left = x;
            y = pq.remove();
            z.right = y;
            z.data = x.data + y.data;
            System.out.println(z.data+"is the root of "+x.data+"and"+y.data);
        }
    }

    public static void main(String[] args) {
        NodeComparator nodeComparator = new NodeComparator();
        PriorityQueue pq = new PriorityQueue(10,nodeComparator);

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the character frequency:");

        for(int i=0;i<6;i++){
            int value = input.nextInt();
            Node node = new Node();
            node.data = value;
            pq.add(node);
        }
        huffman(pq);
    }

}