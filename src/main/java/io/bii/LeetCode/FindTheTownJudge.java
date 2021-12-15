package io.bii.LeetCode;

import java.util.*;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {

        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }


        for (int[] item : trust) {
            int person = item[0];
            int judge = item[1];
            map.put(judge, map.getOrDefault(judge, 0) + 1);

            set.remove(person);
        }

        if (!set.isEmpty()) {
            int xx = (int) set.toArray()[0];
            if (n - 1 == map.get(xx)) return (int) set.toArray()[0];
        }

        return -1;

    }
}
