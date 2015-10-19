package com.company.imperative;

import org.junit.Before;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainTest {

    private String inputString;

    @Before
    public void setup() {
        inputString = "Komal Swapnil Harshad Komal Swapnil Harshad Parag # ! " +
                "@## Parag Komal Swapnil Komal Swapnil Komal Komal Komal";
    }

    @Test
    public void testWordsWithCountInAscendingOrder() {

        Map<String, Integer> expectedMap = new HashMap<String, Integer>();
        expectedMap.put("Harshad", 2);
        expectedMap.put("Parag", 2);
        expectedMap.put("Swapnil", 4);
        expectedMap.put("Komal", 7);

        Map<String, Integer> expectedOccurance = new TreeMap<String, Integer>(new MapAscendingSort(expectedMap));
        expectedOccurance.putAll(expectedMap);
        Map<String, Integer> actualOccurance = Main.getWordsWithOccuranceInAscendingOrder(inputString);

        assertTrue(Main.compareMaps(expectedOccurance, actualOccurance));
    }

    @Test
    public void getDelimeterSeparatedWordsFromLine() {
        List<String> expectedList = new ArrayList<String>() {
            {
                add("Komal");
                add("Swapnil");
                add("Harshad");
                add("Komal");
                add("Swapnil");
                add("Harshad");
                add("Parag");
                add("Parag");
                add("Komal");
                add("Swapnil");
                add("Komal");
                add("Swapnil");
                add("Komal");
                add("Komal");
                add("Komal");
            }
        };
        List<String> actualList = Main.getDelimeterSeparatedWordsFromLine(inputString, "\\w+");
        assertEquals(expectedList.size(), actualList.size());
        Iterator<String> expectedIterator = expectedList.iterator();
        Iterator<String> actualIterator = actualList.iterator();
        while (expectedIterator.hasNext()) {
            assertEquals(expectedIterator.next(), (actualIterator.next()));
        }
    }
}