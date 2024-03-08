package com.borani.stream;

import java.util.HashMap;
import java.util.Map;

public class NthSalary {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("vivek", 100);
        map.put("Rinku", 400);
        map.put("vishal", 600);
        map.put("shankar", 500);
        map.put("shyam", 500);
        map.put("tinku", 300);
        System.out.println(findNthSalary(map, 2));
    }

    private static boolean findNthSalary(Map<String, Integer> map, int i) {

        //map.entrySet().stream().collect()
        return false;
    }
}
