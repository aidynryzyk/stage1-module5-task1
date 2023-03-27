package com.epam.mjc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String s:
                 x) {
                if (Character.isDigit(s.charAt(0)) || Character.isLowerCase(s.charAt(0))) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            int len = x.size();
            for (int i = 0; i < len; i++) {
                if (x.get(i) % 2 == 0) {
                    x.add(x.get(i));
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream()
                .filter(x -> Character.isUpperCase(x.charAt(0)))
                .filter(x -> x.endsWith("."))
                .filter(x -> x.split(" ").length > 3)
                .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            for (String s:
                 x) {
                map.put(s, s.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }
}
