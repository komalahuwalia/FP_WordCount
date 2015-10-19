package com.company.functional;

import com.company.imperative.*;
import com.company.maputils.MapAscendingSort;
import com.company.maputils.MapUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MainTest {


    private String inputString;

    @Before
    public void setup() {
        inputString = "Komal Swapnil Harshad Komal Swapnil Harshad Parag # ! " +
                "@## Parag Komal Swapnil Komal Swapnil Komal Komal Komal";
    }

    @Test
    public void testWordsWithCountInAscendingOrder(){
        Map<String, Integer> expectedMap = new HashMap<String, Integer>();
        expectedMap.put("Harshad", 2);
        expectedMap.put("Parag", 2);
        expectedMap.put("Swapnil", 4);
        expectedMap.put("Komal", 7);

        Map<String, Integer> expectedOccurance = new TreeMap<String, Integer>(new MapAscendingSort(expectedMap));
        expectedOccurance.putAll(expectedMap);
        Map<String, Integer> actualOccurance = Main.getWordsWithOccurrenceInAscendingOrder(inputString);

    }

}