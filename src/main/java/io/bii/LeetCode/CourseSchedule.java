package io.bii.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CourseSchedule {


    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        boolean[] visited = new boolean[numCourses];

        for (int[] prerequisite : prerequisites) {

            ArrayList<Integer> value = map.getOrDefault(prerequisite[1], new ArrayList<>());
            value.add(prerequisite[0]);

            map.put(prerequisite[1], value);

        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            if (!visited[entry.getKey()] && !canFinishUtil(entry.getKey(), entry.getValue(), map, visited))
                return false;
        }

        return true;

    }

    private boolean canFinishUtil(int key, ArrayList<Integer> value, Map<Integer, ArrayList<Integer>> map, boolean[] visited) {


        visited[key] = true;

        for (Integer integer : value) {
            if (map.containsKey(integer) && visited[integer]) return false;
            else return canFinishUtil(integer, map.getOrDefault(integer, new ArrayList<>()), map, visited);
        }

        visited[key] = false;

        return true;

    }
}
