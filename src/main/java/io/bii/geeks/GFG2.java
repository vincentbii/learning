package io.bii.geeks;

//public class GFG2 {
//}


import java.util.*;

public class GFG2 {
    static Map<Long, Long> map = new HashMap<>();

    public static long fib(long n) {
        if (n == 0)
            return 0;
        if (n == 2 || n == 1)
            return 1;
        if (map.containsKey(n))
            return map.get(n);
        if (n % 2 != 0) {
            long k = (n + 1) / 2;
            map.put(n, (fib(k) * fib(k) + fib(k - 1) * fib(k - 1)) % 1000000007);
        } else {
            long k = n / 2;
            map.put(n, (fib(k) * ((fib(k - 1) << 1) + fib(k))) % 1000000007);

        }
        return map.get(n);
    }

    public static void main(String[] args) {
        Scanner ab = new Scanner(System.in);
        int t = ab.nextInt();
        while (t-- > 0) {
            System.out.println(fib(ab.nextLong() + 1));
        }
    }

    public static long minStart(List<Integer> arr) {
        int startMin = 1;
        int finalMin;
        if (arr.size() > 0) {
            if (arr.get(0) > 0) {
                startMin = arr.get(0) + startMin;
            } else {
                startMin = Math.abs(arr.get(0)) + startMin;
            }
        }
        finalMin = startMin;

        for (int i = 1; i < arr.size(); i++) {
            if (startMin - arr.get(i) < 1) {
                finalMin = startMin + Math.abs(arr.get(i)) + 1;
                startMin = 1;
            } else {
                startMin = startMin - arr.get(i);
            }
        }

        return finalMin;

    }


    public static List<String> preprocessDate(List<String> dates) {
        // Write your code here
        List<String> result = new ArrayList<>();
        for (String date : dates) {
            String[] thisdate = date.split(" ");
            String day = thisdate[0].substring(0, thisdate[0].length() - 2);
            if (day.length() == 1) {
                day = "0" + day;
            }
            String month = thisdate[1];
            month = month.equalsIgnoreCase("Jan") ? "01"
                    : month.equalsIgnoreCase("feb") ? "02"
                    : month.equalsIgnoreCase("Mar") ? "03"
                    : month.equalsIgnoreCase("Apr") ? "04"
                    : month.equalsIgnoreCase("May") ? "05"
                    : month.equalsIgnoreCase("Jun") ? "06"
                    : month.equalsIgnoreCase("Jul") ? "07"
                    : month.equalsIgnoreCase("Aug") ? "08"
                    : month.equalsIgnoreCase("Sep") ? "09"
                    : month.equalsIgnoreCase("Oct") ? "10"
                    : month.equalsIgnoreCase("Nov") ? "11"
                    : month.equalsIgnoreCase("Dec") ? "12"
                    : "";
            result.add(thisdate[2] + "-" + month + "-" + day);

        }

        return result;
    }


    static int counting(String s) {

        if (s == null) return 0;
        if (s.length() <= 1) return 0;

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() != s.charAt(i)) {
                count++;
                stack.pop();
            } else if (stack.isEmpty() && s.charAt(i) != s.charAt(i - 1)) {
                count++;
                stack.push(s.charAt(i));
            } else {
                stack.push(s.charAt(i));
            }
        }
        return count;
    }

}