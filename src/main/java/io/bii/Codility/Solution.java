package io.bii.Codility;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> sol = solution(new int[]{4, 3, 5, 2}, 7);
        System.out.println(sol);
    }

    private static List<List<Integer>> solution(int[] ints, int target) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();

        for (int i : ints) {
//            System.out.println(i);
            System.out.println("=====");
            list1.add(i);
            int remainder = target - i;

            if (remainder > 0) {
                return solution(ints, remainder);
            }

            if (remainder == 0) {
                System.out.println(list1);
                list.add(list1);
            }

        }

        return list;
    }
}