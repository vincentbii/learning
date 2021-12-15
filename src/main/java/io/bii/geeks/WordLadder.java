package io.bii.geeks;

import java.util.*;
import java.util.stream.Collectors;

public class WordLadder {
    public static void main(String[] args) {
        String[] strings = new String[]{"ABCD", "EBAD", "EBCD", "XYZA"};
        List<String> set = Arrays.stream(strings).collect(Collectors.toList());
        String start = "ABCV";
        String stop = "EBAD";
        int minChain = new WordLadder().ladderLength(start, stop, set);
        System.out.println(minChain);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            List<Integer> list = map.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);
            map.put(prerequisite[1], list);
        }

        boolean[] visited = new boolean[numCourses];

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {

            if (!visited[entry.getKey()] && dfs(map, entry.getKey(), visited)) return true;

        }

        return false;
    }

    private boolean dfs(Map<Integer, List<Integer>> map, Integer key, boolean[] visited) {

        visited[key] = true;
        for (Integer integer : map.get(key)) {
            if (visited[integer]) return false;
            else return dfs(map, integer, visited);
        }

        return true;
    }

    private boolean canFinishUtil(boolean[] visited, int i, LinkedList<Integer>[] linkedList) {

        visited[i] = true;
        for (Integer item : linkedList[i]) {
            if (linkedList[i].isEmpty()) return false;
            if (visited[item]) return false;
            return canFinishUtil(visited, item, linkedList);
        }

        return true;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) return 0;

        Set<String> wordSet = new HashSet<>(wordList);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String item = queue.poll();
                wordSet.remove(item);

                char[] itemArray = item.toCharArray();
                for (int k = 0; k < itemArray.length; k++) {
                    for (char alpha = 'A'; alpha <= 'z'; alpha++) {

                        itemArray[k] = alpha;

                        String itemWord = String.valueOf(itemArray);

                        if (itemWord.equals(endWord)) return depth + 1;

                        if (wordSet.contains(itemWord)) {
                            wordSet.remove(itemWord);
                            queue.offer(itemWord);
                        }

                    }
                    itemArray[k] = item.charAt(k);
                }
            }
        }


        return 0;

    }
}
