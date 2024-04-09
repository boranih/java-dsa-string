package com.borani.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateCharactersInString {

    public static void main(String[] args) {
        System.out.println(new DuplicateCharactersInString().findDuplicate("HemantKumarBoranibbbbbbhhhhhhhhhhhuuuuuuuuiiiiiiinhnhnh"));
        System.out.println(new DuplicateCharactersInString().findDuplicateWithOccurance("HemantKumarBoranibbbbbbhhhhhhhhhhhuuuuuuuuiiiiiiinhnhnh"));

    }

    public List<String> findDuplicate(String input) {
        return Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
                .entrySet()
                .stream().filter(entryValue -> entryValue.getValue() > 1)
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public Map<String, Long> findDuplicateWithOccurance(String input) {
        return Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
                .entrySet()
                .stream().filter(entryValue -> entryValue.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
