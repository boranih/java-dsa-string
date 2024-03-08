package com.borani.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateKey {

    public static void main(String[] args) {
        List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
        Map<String, Integer> collect = listWithDuplicates.stream()
                .collect(Collectors.toMap(Function.identity(), String::length, (item, identicalItem) -> item));
        System.out.println(collect);

        //Grouping By
        Map<Integer, Set<String>> collect1 = listWithDuplicates.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(collect1);
    }
}


