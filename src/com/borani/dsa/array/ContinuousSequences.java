package com.borani.dsa.array;

import java.util.function.Consumer;

public class ContinuousSequences {

    public static void main(String[] args) {
        Integer inputArr[] = {3, 2, 3, 5, 9, 6, 7, 8, 4, -5, -7, -3, -2, -1};
        Consumer<Integer[]> findConsumer = ContinuousSequences::findSequence;
        findConsumer.accept(inputArr);

    }

    public static void findSequence(Integer[] arr) {
        StringBuilder sb = new StringBuilder();
        int j = 1;
        int i = 0;
        boolean match = false;
        while (i < arr.length) {
            if (arr[i] + 1 == arr[j] && j < arr.length) {
                sb.append(arr[i]);
                match = true;
            } else if (match) {
                sb.append(arr[i]);
                match = false;
            } else if (j == arr.length && match) {
                sb.append(arr[j]);
                match = false;
            }
            i++;
            j++;
        }
        System.out.println(sb.toString());
    }
}
