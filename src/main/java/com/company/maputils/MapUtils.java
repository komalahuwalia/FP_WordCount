package com.company.maputils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

public class MapUtils {

    public static boolean compareMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        if (map1.size() != map2.size()) return false;
        boolean areEqual = true;
        Iterator<String> iteratorExpected = map1.keySet().iterator();
        Iterator<String> iteratorActual = map2.keySet().iterator();

        while (iteratorExpected.hasNext()) {
            String expectedWord = iteratorExpected.next();
            String actualWord = iteratorActual.next();
            if (!expectedWord.equals(actualWord)) {
                areEqual = false;
                break;
            }
            if (map1.get(expectedWord).intValue() !=
                    map2.get(actualWord).intValue()) {
                areEqual = false;
                break;
            }
        }
        return areEqual;
    }

}


