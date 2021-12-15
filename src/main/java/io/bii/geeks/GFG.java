package io.bii.geeks;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

class Cow {
    private int years;


    public Cow(int i) {
        this.years = i;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}

public class GFG {

    public static void main(String[] args) throws InterruptedException {
        for (String item : Arrays.asList("1", "2", "#")) {

            System.out.println(item);
            System.out.println(LocalDateTime.now());
            TimeUnit.SECONDS.sleep(5);

        }
    }

    public int TotalAnimal(long N) {
        Queue<Cow> queue = new LinkedList<>();

        queue.add(new Cow(0));
        int index = 1;

        while (!queue.isEmpty() && index <= N) {

            int l = queue.size();

            for (int i = 0; i < l; i++) {
                Cow item = queue.poll();
                item.setYears(item.getYears() + 1);
                queue.add(item);

                if (item.getYears() >= 2) queue.add(new Cow(0));
            }


            index++;
        }

        return queue.size();
    }

    private final ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

//    public GFG(int v) {
//        for (int i = 0; i < v; i++) {
//            arrayList.add(i, new ArrayList<>());
//        }
//    }
//
//    public static void main(String[] args) {
//
//        int v = 4;
//        GFG gfg = new GFG(v);
//        gfg.addEdge(0, 1);
//        gfg.addEdge(1, 2);
////        gfg.addEdge(1, 4);
////        gfg.addEdge(2, 1);
//        gfg.addEdge(2, 3);
////        gfg.addEdge(4, 3);
//        if (gfg.isCycle(v, gfg.arrayList)) {
//            System.out.println("Is Cyclic");
//        } else {
//            System.out.println("Not Cyclic");
//        }
//
//    }

    private void addEdge(int src, int dest) {
        arrayList.get(src).add(dest);
        arrayList.get(dest).add(src);
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && hasCycle(visited, i, adj, -1)) return true;
        }

        return false;
    }

    private boolean hasCycle(boolean[] visited, int i, ArrayList<ArrayList<Integer>> adj, int parent) {

        visited[i] = true;

        for (Integer item : adj.get(i)) {
            if (!visited[item]) {
                if (hasCycle(visited, item, adj, i)) {
                    return true;
                }
            } else if (item != parent) {
                return true;
            }
        }

        return false;
    }

}

