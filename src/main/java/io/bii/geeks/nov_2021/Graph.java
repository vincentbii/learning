package io.bii.geeks.nov_2021;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int key;
    Node right;
    Node left;

    public Node(int k) {
        right = left = null;
        this.key = k;
    }
}

public class Graph {
    private Node root;
    int count = 0;

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.root = new Node(5);
        graph.root.left = new Node(-10);
        graph.root.right = new Node(3);
        graph.root.left.left = new Node(9);
        graph.root.left.right = new Node(8);
        graph.root.right.left = new Node(-4);
        graph.root.right.right = new Node(7);

        Graph graph2 = new Graph();
        graph2.root = new Node(1);
        graph2.root.left = new Node(2);
        graph2.root.right = new Node(3);
//        graph.root.left.left = new Node(9);
//        graph.root.left.right = new Node(8);
//        graph.root.right.left = new Node(-4);
//        graph.root.right.right = new Node(7);

        System.out.println(graph.countSubtreesWithSumX(graph.root, 7));
        System.out.println(graph2.countSubtreesWithSumX(graph2.root, 5));
    }

    int countSubtreesWithSumX(Node root, int x) {
        findSum(root, x);
        return count;
    }

    int findSum(Node root, int x) {
        if (root == null) {
            return 0;
        }
        int currSum = root.key + findSum(root.left, x) + findSum(root.right, x);
        if (currSum == x) {
            count++;
        }
        return currSum;
    }
}
