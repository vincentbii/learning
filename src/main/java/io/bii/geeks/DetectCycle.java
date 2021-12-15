package io.bii.geeks;

import java.util.LinkedList;

public class DetectCycle {
    private LinkedList<Integer>[] linkedLists;
    private int E;
    private int V;

    public DetectCycle(int e, int v) {
        E = e;
        V = v;

        linkedLists = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            linkedLists[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest) {
        linkedLists[src].add(dest);
    }

    boolean dfs(boolean[] visited, boolean[] recStack, int i) {

        if (recStack[i]) return true;
        if (visited[i]) return false;
        visited[i] = true;
        recStack[i] = true;

        for (Integer integer : linkedLists[i]) {
            if (dfs(visited, recStack, integer)) return true;
        }

        recStack[i] = false;

        return false;
    }

    boolean solve() {

        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        for (int i = 0; i < V; i++) {

            if (!visited[i] && dfs(visited, recStack, i)) return true;

        }

        return false;

    }

    public static void main(String[] args) {

        DetectCycle graph = new DetectCycle(6, 4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        boolean hasCycle = graph.solve();
        System.out.println(hasCycle ? "Has Cycle" : "No Cycle");
    }
}
