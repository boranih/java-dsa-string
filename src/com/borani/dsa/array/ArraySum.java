package com.borani.dsa.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraySum {

    public static void main(String[] args) {

    }

    public Long arraySum(List<Long> ar) {
        return ar.stream()
                .collect(Collectors.summingLong(Long::longValue));
    }
}
