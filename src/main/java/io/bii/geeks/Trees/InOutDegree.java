package io.bii.geeks.Trees;

import java.util.Arrays;
import java.util.LinkedList;

public class InOutDegree {
    private int V;
    private final LinkedList<Integer>[] lists;

    public InOutDegree(int v) {
        this.V = v;
        lists = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            lists[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        InOutDegree inOutDegree = new InOutDegree(7);
        inOutDegree.push(0, 1);
        inOutDegree.push(0, 2);
        inOutDegree.push(1, 3);
        inOutDegree.push(2, 5);
        inOutDegree.push(2, 6);
        inOutDegree.push(2, 0);
        inOutDegree.push(3, 1);
        inOutDegree.push(3, 4);
        inOutDegree.push(4, 3);
        inOutDegree.push(4, 2);
        inOutDegree.push(5, 6);
        inOutDegree.push(5, 4);
        inOutDegree.push(6, 5);

        printList(inOutDegree.lists, inOutDegree.V);
    }

    private static void printList(LinkedList<Integer>[] lists, int v) {
        int[] in = new int[v];
        int[] out = new int[v];


        for (int i = 0; i < v; i++) {
            out[i] = lists[i].size();

            for (Integer integer : lists[i]) {
                in[integer] = in[integer] + 1;
            }
        }

        System.out.println(Arrays.toString(in));
        System.out.println(Arrays.toString(out));
    }

    private void push(int src, int dest) {
        lists[src].add(dest);
    }
}
