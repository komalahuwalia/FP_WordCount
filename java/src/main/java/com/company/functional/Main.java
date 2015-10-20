package com.company.functional;
import com.company.maputils.MapUtils;
import java.util.*;

public class Main {

    public static Map<String, Integer> getWordsWithOccurrenceInAscendingOrder(String inputString) {
        List<String> words = Arrays.asList(inputString.split("\\w+"));
        Map<String, Integer> wordOccurrence = new HashMap<>();
        words.stream().forEach(x -> wordOccurrence.put(x, wordOccurrence.getOrDefault(x, 0) + 1));
        return MapUtils.sortMapWithAscendingByOccuranceThenByKey(wordOccurrence);
    }
}
