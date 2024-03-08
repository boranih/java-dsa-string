package com.borani.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateCharactersInString {

    public static void main(String[] args) {
        System.out.println(new DuplicateCharactersInString().findDuplicate("HemantKumarBoranibbbbbbhhhhhhhhhhhuuuuuuuuiiiiiiinhnhnh"));
        System.out.println(new DuplicateCharactersInString().findDuplicateWithOccurance("HemantKumarBoranibbbbbbhhhhhhhhhhhuuuuuuuuiiiiiiinhnhnh"));

    }

    public List<String> findDuplicate(String input) {
        List<String> collect = Arrays.asList(input.split("")).stream()
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
                .entrySet()
                .stream().filter(entryValue -> entryValue.getValue()>1)
                .map(entryKey->entryKey.getKey()).collect(Collectors.toList());

        return collect;
    }

    public Map<String, Long> findDuplicateWithOccurance(String input) {
        Map<String, Long> collect = Arrays.asList(input.split("")).stream()
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
                .entrySet()
                .stream().filter(entryValue -> entryValue.getValue()>1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return collect;
    }
}
