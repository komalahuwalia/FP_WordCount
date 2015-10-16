package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static Map<String, Integer> getWordsWithOccuranceInAscendingOrder(String line) {
        List<String> wordList = getDelimeterSeparatedWordsFromLine(line, "\\w+");
        Map<String, Integer> occurrence = new HashMap();
        Iterator<String> listIterator = wordList.iterator();
        while (listIterator.hasNext()) {
            String word = listIterator.next();
            if (occurrence.get(word) != null)
                occurrence.put(word, occurrence.get(word) + 1);
            else
                occurrence.put(word, 1);
        }
        return sortMapWithAscendingByOccuranceThenByKey(occurrence);
    }

    private static Map<String, Integer> sortMapWithAscendingByOccuranceThenByKey(Map<String, Integer> map) {

        Map<String, Integer> ascendingMap = new TreeMap<>(new MapAscendingSort(map));
        ascendingMap.putAll(map);
        return ascendingMap;
    }

    public static List<String> getDelimeterSeparatedWordsFromLine(String words, String delimeter) {
        List<String> wordList = new ArrayList<>();
        Matcher m = Pattern.compile(delimeter).matcher(words);
        while (m.find()) {
            wordList.add(m.group());
        }
        return wordList;
    }
}

class MapAscendingSort implements Comparator {
    private final Map map;

    public MapAscendingSort(Map map) {
        this.map = map;
    }

    public int compare(Object o1, Object o2) {
        int comparison = ((Integer) map.get(o1)).intValue() - ((Integer) map.get(o2)).intValue();
        if (comparison == 0) {
            return ((String) o1).compareTo((String) o2);
        } else {
            return comparison;
        }
    }
}

