package io.bii.geeks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        System.out.println(max_of_subarrays(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 9, 3));
    }

    static ArrayList<Integer> max_of_subarrays(int[] arr, int n, int k) {

        List<Integer> list = new ArrayList<>();
        ArrayList<Integer> maxs = new ArrayList<>();

        int start = 0;

        while (start < n) {
            list.add(arr[start]);

            if (start + 1 >= k) {
                int max = list.stream().mapToInt(x -> x).max().getAsInt();
                System.out.println(list);
                System.out.println(max);
                maxs.add(max);
                list.remove(0);
            }

            start++;
        }

        return maxs;
    }
}
