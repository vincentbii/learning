package io.bii.geeks;

import java.util.*;

// { Driver Code Starts
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) throws IOException {

        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }

            System.out.println(Solution_20211025.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Edge {

    private int u;
    private int v;
    private int w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }
}

class Solution_20211025 {
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Edge::getW));

        for (int i = 0; i < V; i++) {
            ArrayList<ArrayList<Integer>> u = adj.get(i);
            for (ArrayList<Integer> edge : u) {
                Integer v = edge.get(0);
                Integer w = edge.get(1);
                priorityQueue.add(new Edge(i, v, w));
            }
        }

        int TotalWeight = 0;

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!Find(edge.getU(), parent).equals(Find(edge.getV(), parent))) {
                TotalWeight += edge.getW();
                Union(edge.getU(), edge.getV(), parent);
            }
        }

        return TotalWeight;
    }

    private static void Union(int u, int v, int[] parent) {
        if (parent[v] == -1) {
            parent[v] = u;
            return;
        }

        Union(parent[u], v, parent);
    }

    private static Integer Find(int vertex, int[] parent) {
        return parent[vertex];
    }
}


class Solution_1 {

    long minCost(long[] arr, int n) {

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long l : arr) {
            pq.add(l);
        }

        long sum = 0;
        while (pq.size() > 1) {
            long first = pq.poll();
            long second = pq.poll();
            long thisSum = first + second;
            pq.add(thisSum);
            sum = sum + thisSum;
        }


        return sum;

    }

    public boolean isPossible(int N, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            ArrayList<Integer> list = map.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);
            map.put(prerequisite[1], list);
        }

        boolean[] visited = new boolean[N];
        boolean[] recStack = new boolean[N];

        System.out.println(map);

        for (Integer i : map.keySet()) {
            if (!visited[i] && dfs(map, visited, recStack, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(Map<Integer, ArrayList<Integer>> linkedList, boolean[] visited, boolean[] recStack, int i) {

        if (recStack[i]) return true;
        if (visited[i]) return false;

        visited[i] = true;
        recStack[i] = true;

        if (linkedList.containsKey(i)) {
            for (Integer integer : linkedList.get(i)) {
                if (dfs(linkedList, visited, recStack, integer)) {
                    return true;
                }
            }
        }
        recStack[i] = false;

        return false;
    }

//    public static void main(String[] args) {
//        System.out.println(new Solution().maxArea(new int[][]{
//                {0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}
//        }, 4, 4));
//    }

    public int maxArea(int[][] M, int n, int m) {

        int[][] dp = M.clone();

        int eachMax = 0;
        int row = 0, col = 0, maxR = 0, maxC = 0, max = dp[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                } else if (M[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                } else {
                    dp[i][j] = 0;
                }

                if (dp[i][j] == 0) {
                    row = i;
                    col = j;
                }

                if (dp[i][j] != 0) {
                    max = dp[i][j];
                    eachMax = Math.max(eachMax, ((i - row + 1) * (col - j + 1)));
                    System.out.println(max + "::" + row + "::" + i + "::" + col + "::" + j);
                }


            }
        }

        for (int[] i : dp) {
            System.out.println(Arrays.toString(i));
        }

        return eachMax;

    }
}
