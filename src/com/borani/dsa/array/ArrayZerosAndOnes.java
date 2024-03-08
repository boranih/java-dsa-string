package com.borani.dsa.array;

import java.util.Arrays;

public class ArrayZerosAndOnes {

    public static void main(String[] args) {
        Integer array[] = {1, 1, 0, 1, 0};

        Integer[] array1 = Arrays.stream(array).sorted().toArray(Integer[]::new);
        //Output will be [000111]
        System.out.println("Sorted Array : -> " + Arrays.toString(array1));
        new ArrayZerosAndOnes().swapArray(array);
    }

    public void swapArray(Integer[] array) {
        int left = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                int temp = array[i];
                array[i] = array[left];
                array[left] = temp;
                left++;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
