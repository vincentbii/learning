package io.bii;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ona {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input1 = br.readLine();
        String input2 = br.readLine();

        Set<String> xElements = new HashSet<>(Arrays.asList(input1.trim().split(",")));

        StringBuilder solution = new StringBuilder();

        for (String yElement : input2.trim().split(",")) {

            if (xElements.contains(yElement)){
                solution.append(yElement).append(",");
                xElements.remove(yElement);
            }

        }

        System.out.println(solution.deleteCharAt(solution.length() - 1));

    }
}