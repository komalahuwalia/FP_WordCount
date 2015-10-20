package com.company.maputils;

import java.util.Comparator;
import java.util.Map;

public class MapAscendingSort implements Comparator {


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
