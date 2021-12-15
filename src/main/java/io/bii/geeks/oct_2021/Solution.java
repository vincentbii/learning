package io.bii.geeks.oct_2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Vincent"));
        employeeList.add(new Employee("Bii"));

        List<String> list = employeeList.stream().map(Employee::getName).collect(Collectors.toList());

        System.out.println(list);
    }

    public static int swapBits(int n) {

        StringBuilder stringBuilder = new StringBuilder(Integer.toBinaryString(n));
        if (stringBuilder.length() % 2 != 0) stringBuilder.insert(0, 0);
        int l = stringBuilder.length();
        for (int i = 0; i < l - 1; i++) {
            if (i % 2 == 0) {
                char ii = stringBuilder.charAt(i);
                char i2 = stringBuilder.charAt(i + 1);
                stringBuilder.setCharAt(i, i2);
                stringBuilder.setCharAt(i + 1, ii);
            }
        }

        return Integer.parseInt(stringBuilder.toString(), 2);
    }


}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}