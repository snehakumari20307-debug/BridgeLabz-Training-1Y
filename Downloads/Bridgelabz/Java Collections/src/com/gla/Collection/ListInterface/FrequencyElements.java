package com.gla.Collection.ListInterface;

import java.util.*;

public class FrequencyElements {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange");

        Map<String, Integer> freqMap = new HashMap<>();

        for (String item : list) {
            if (freqMap.containsKey(item)) {
                freqMap.put(item, freqMap.get(item) + 1);
            } else {
                freqMap.put(item, 1);
            }
        }

        System.out.println(freqMap);
    }
}

