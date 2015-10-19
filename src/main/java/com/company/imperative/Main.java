package com.company.imperative;
import com.company.maputils.MapUtils;

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

        Map<String, Integer> ascendingMap = new TreeMap<>(new MapUtils().MapAscendingSort(map));
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


