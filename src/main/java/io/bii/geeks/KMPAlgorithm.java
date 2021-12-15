package io.bii.geeks;

import java.util.ArrayList;
import java.util.Collections;

public class KMPAlgorithm {
    ArrayList<Integer> search(String pat, String txt) {
        if (pat == null || pat.isEmpty()) return (ArrayList<Integer>) Collections.singletonList(-1);
        int l = pat.length();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) == pat.charAt(0) && (i + l) < txt.length() && txt.substring(i, i + l).equals(pat)) {
                res.add(i + 1);
            }
        }

        if (res.isEmpty()) res.add(-1);

        return res;
    }
}
