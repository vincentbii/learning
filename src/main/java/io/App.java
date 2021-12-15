package io;

import java.util.Arrays;
import java.util.Stack;

public class App {

    boolean ispar(String x) {

        int len = x.length();

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (st.isEmpty()) {
                st.push(x.charAt(i));
            } else {
                Character item = st.peek();
                if (item.equals('[') && x.charAt(i) == ']') st.pop();
                else if (item.equals('(') && x.charAt(i) == ')') st.pop();
                else if (item.equals('{') && x.charAt(i) == '}') st.pop();
                else st.push(x.charAt(i));
            }
        }

        return st.size() == 0;
    }

    int countRev(String s) {
        int len = s.length();

        if (len % 2 != 0) return -1;
        float c = 0, o = 0;

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '{') {
                st.push(s.charAt(i));
                o++;
            } else {
                if (st.size() > 0) {

                    st.pop();
                    o--;

                } else {
                    c++;
                }
            }
        }

        return (int) (Math.ceil(c / 2) + Math.ceil(o / 2));
    }

    static int countRev__(String s) {
        if (s.length() % 2 != 0) return -1;

        Stack<Character> st = new Stack<>();
        float o = 0, c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                st.push(s.charAt(i));
                o++;
            } else {
                if (st.size() > 0) {
                    st.pop();
                    o--;
                } else c++;
            }
        }
        System.out.println(Math.ceil(c / 2));
        System.out.println(Math.ceil(o / 2));
        return (int) (Math.ceil(c / 2) + Math.ceil(o / 2));
    }

    public int MinimumWalk(int[][] graph, int u, int v, int k) {

        int V = graph.length;
        int[][] count = new int[V][V];

        for (int e = 0; e <= k; e++) {
            for (int i = 0; i < V; i++) {
                if (e == 0 && i == v) count[i][e] = 1;
                else if (e == 1 && graph[i][e] == 1) count[i][e] = 1;
//                if (e == 0) count[i][e] = 0;
                else if (e > 1) {
                    for (int j = 0; j < V; j++) {
                        if (graph[i][j] == 1) {
                            count[i][e] += graph[i][e - 1];
                        }
                    }
                }
            }
        }

        System.out.println(graph[u][k]);
        for (int[] ints : count) {
            System.out.println(Arrays.toString(ints));
        }

        return 0;
    }

    public int MinimumWalk_(int[][] graph, int u, int v, int k) {

        if (k == 0 && u == v) return 1;
        if (k == 1 && graph[u][v] == 1) return 1;
        if (k == 0) return 0;

        int count = 0;
        int V = graph.length;


        for (int i = 0; i < V; i++) {
            if (graph[u][i] == 1) {
                count += MinimumWalk(graph, i, v, k - 1);
            }
        }


        return count;
    }

    boolean isHeap(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int n = arr.length;

        int hl = n / 2;

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index <= hl) {
            stringBuilder.append("index").append(index).append("\n");
            int leftIndex = getLeftIndex(index, n);
            stringBuilder.append("leftIndex::").append(leftIndex);
            if (leftIndex > index && arr[index] < arr[leftIndex]) return false;
            int rightIndex = getRightIndex(index, n);
            stringBuilder.append("rightIndex::").append(rightIndex);
            if (rightIndex > index && arr[index] < arr[rightIndex]) return false;
            index++;
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString());

        return true;
    }

    private int getLeftIndex(int index, int n) {
        int lindex = (index * 2) + 1;
        if (lindex < n) return lindex;
        return 0;
    }

    private int getRightIndex(int index, int n) {
        int lindex = (index * 2) + 2;
        if (lindex < n) return lindex;
        return 0;
    }

    void mirror(Node node) {
        if (node == null) return;
        if (node.left == null && node.right == node) return;
        if (node.left == null) {
            node.left = new Node(node.right.data);
            node.right = null;
        }
        if (node.right == null) {
            node.right = new Node(node.left.data);
            node.left = null;
        }

    }

    private static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
}
