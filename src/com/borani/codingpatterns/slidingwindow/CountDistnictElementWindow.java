package com.borani.codingpatterns.slidingwindow;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.Map;public class CountDistnictElementWindow {    public static void main(String[] args) {    }    static ArrayList<Integer> countDistinct(int A[], int n, int k) {        ArrayList<Integer> count = new ArrayList<>();        Map<Integer, Integer> frequencyMap = new HashMap<>();        int distinctCount = 0;        for (int i = 0; i < A.length; i++) {            frequencyMap.put(A[i], frequencyMap.getOrDefault(A[i], 0) + 1);            if (i >= k - 1) {                count.add(distinctCount);            }        }        return count;    }}